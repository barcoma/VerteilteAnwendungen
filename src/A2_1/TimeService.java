package A2_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {
    private ServerSocket serverSocket = new ServerSocket(75);
    private Socket clientSocket = serverSocket.accept();

    //create buffered writer
    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

    public TimeService() throws IOException {
    }

}
