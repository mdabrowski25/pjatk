package pl.edu.pjwstk.project;

import java.io.*;
import java.net.Socket;

public class TCPController {

    public static Boolean sendRequest(Socket socket, String request, NetworkNode node) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            String line = request + " " + node.getId() + " " + node.getPort() + " " + node.getIp() + " " + node.getAllResources();
            printWriter.println(line);
            printWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String receiveRequest(Socket socket) {
        String request = "";
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            request = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }
}
