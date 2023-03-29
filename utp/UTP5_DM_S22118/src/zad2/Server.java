/**
 * @author Dąbrowski Mateusz S22118
 */

package zad2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Server implements Runnable {

    private ServerSocket socketServer;
    private Socket socketClient;
    private ServerWorker serverworker;
    private FutureTask<String> futureTask;
    private String dataRes = null;

    public Server(int portServer) throws IOException {
        socketServer = new ServerSocket(portServer);

    }

    @Override
    public void run() {
        while (true) {
            try {
                socketClient = socketServer.accept();
                serverworker = new ServerWorker(socketClient);
            } catch (IOException e) {
                e.printStackTrace();
            }

            futureTask = new FutureTask<String>(serverworker);
            new Thread(futureTask).start();

            try {
                dataRes = futureTask.get();
                System.out.println(dataRes);
                futureTask.cancel(true);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Server Interrupted");
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(4445);
        new Thread(server).start();
    }
}
