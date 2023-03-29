package zad2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {
    private Socket socketClient;
    private Scanner scanner = new Scanner(System.in);
    private PrintWriter writer;
    private String addressClient;
    private String portClient;
    private String data = null;

    public Client(int portServer) throws UnknownHostException, IOException {
        this.socketClient = new Socket("localhost",portServer);
        this.addressClient = this.socketClient.getInetAddress().getHostAddress();
        this.portClient = Integer.toString(this.socketClient.getPort());
    }

    @Override
    public void run() {
        while(true) {
            data = scanner.nextLine();
            try {
                writer = new PrintWriter(this.socketClient.getOutputStream());
                writer.println(data);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public String showInfo() {
        return "Client info: " + addressClient + " " + portClient;
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(4445);
        new Thread(client).start();
    }
}
