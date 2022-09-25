package pl.edu.pjwstk.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkNode extends BasicNode {

    private String gateway;
    private BasicNode parentNode;
    private List<NetworkNode> childrenNodes;
    private ServerSocket serverSocket;
    private ResourceController resourceController;

    public NetworkNode(Integer id, Integer listeningPort, String gateway, ResourceController resourceController) {
        super(id, listeningPort);
        this.gateway = gateway;
        this.childrenNodes = new ArrayList<>();
        this.resourceController = resourceController;

        try {
            this.parentNode = (gateway == null ? null : new BasicNode(gateway));
            serverSocket = new ServerSocket(listeningPort);
            if (parentNode != null) {
                Socket socket = new Socket(parentNode.getIp(), parentNode.getPort());
                Boolean childAdded = TCPController.sendRequest(socket, "--addChild", this);
                if (childAdded) {
                    System.out.println("Request to add child node was successful");
                }
            }

            /* Starting to listen */

            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            while (!threadPool.isShutdown()) {
                threadPool.submit(new ConnectionHandler(serverSocket.accept(), this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getAllResources() {
        StringBuilder resources = new StringBuilder();
        ConcurrentHashMap<Character, Integer> allResources = resourceController.getAllResources();
        allResources.forEach((k, v) -> resources.append(k).append(":").append(v).append(" "));
        return resources.toString();
    }

    public void handleConnection(Socket socket) throws IOException {
        String request = TCPController.receiveRequest(socket);
        String[] requestParts = request.split(" ");
        String command = requestParts[0];
        String[] parameters = new String[requestParts.length - 1];
        System.arraycopy(requestParts, 1, parameters, 0, requestParts.length - 1);
        switch (command) {
            case "--addChild":
                addChild(parameters);
                System.out.println("Child node added");
                break;
//            case "--syncResources":
//                addResources(resources);
//                System.out.println("Resources from child added");
//                break;
        }

    }


    public void addChild(String[] params) throws IOException {
        String[] resources = new String[params.length - 3];
        int counter = 0;
        for (int i = 3; i < params.length; i++) {
            resources[counter++] = params[i];
        }
        childrenNodes.add(new NetworkNode(Integer.parseInt(params[0]), Integer.parseInt(params[1]), params[2], new ResourceController(resources)));
        if (parentNode != null) {
            Socket socket = new Socket(parentNode.getIp(), parentNode.getPort());
            Boolean resourcesAdded = TCPController.sendRequest(socket, "addResources", this);
            if (resourcesAdded) {
                System.out.println("Request to add resources was successful");
            }
        }

    }

    public static void main(String[] args) {
        // parameter storage
        String gateway = null;
        int listeningPort = 0;
        String identifier = null;
        List<String> commands = new ArrayList<>();

        // Parameter scan loop
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-ident":
                    identifier = args[++i];
                    break;
                case "-tcpport":
                    listeningPort = Integer.parseInt(args[++i]);
                    break;
                case "-gateway":
                    String[] gatewayArray = args[++i].split(":");
                    gateway = gatewayArray[0] + ":" + gatewayArray[1];
                    break;
                default:
                    commands.add(args[i]);
                    break;
            }
        }

        String[] commandsArray = new String[0];
        if (commands.size() > 0) {
            commandsArray = new String[commands.size()];
            for (int i = 0; i < commands.size(); i++) {
                commandsArray[i] = commands.get(i);
            }
        }
        if (identifier != null) {
            NetworkNode networkNode = new NetworkNode(Integer.parseInt(identifier), listeningPort, gateway, new ResourceController(commandsArray));
        } else {
            System.err.println("No identifier specified");
        }


    }
}
