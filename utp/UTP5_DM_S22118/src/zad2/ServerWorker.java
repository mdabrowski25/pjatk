package zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ServerWorker implements Callable<String> {

    private Socket socketClient;
    private String addressClient;
    private String portClient;
    private String data;
    private String res;
    private BufferedReader bufferIn;

    public ServerWorker(Socket socketClient) {
        this.socketClient = socketClient;
    }

    @Override
    public String call() throws Exception {
        addressClient = socketClient.getInetAddress().getHostAddress();
        portClient = Integer.toString(socketClient.getPort());
        data = null;
        while (true) {
            try {
                bufferIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                while ((data = bufferIn.readLine()) != null) {
                    if (res != null) {
                        res += data;
                    } else {
                        res = "Client" + "[" + addressClient + " ; " + portClient + "]: " + data + "\n";
                    }
                    // . przerywa obsługe zdarzen
                    if (data.matches(".*\\.")) return res;
                }
            } catch (IOException e) {
                return "Server worker Interrupted";
            }
        }

    }
}
