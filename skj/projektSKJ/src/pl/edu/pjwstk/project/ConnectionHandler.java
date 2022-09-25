package pl.edu.pjwstk.project;

import java.net.Socket;

public class ConnectionHandler implements Runnable {
   Socket socket;
   NetworkNode node;

   public ConnectionHandler(Socket socket, NetworkNode node) {
      this.socket = socket;
      this.node = node;
   }

    @Override
    public void run() {
        try {
            node.handleConnection(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
