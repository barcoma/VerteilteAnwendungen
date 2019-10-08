package A2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {

    private static Socket socket;
    private Clock clock;
    public static void main(String[] args)
    {
            try {
                int port = 25000;
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server Started and listening to the port 25000");
               // while (true) {
                    socket = serverSocket.accept();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer.write("time service \n");
                    writer.flush();

                    //Server is running always. This is done using this while(true) loop
                    while (true) {
                        //Reading the message from the client
                        String command = reader.readLine();
                        System.out.println("Message received from client is " + command);

                        //Sending the response back to the client.
                        writer.write(getAnswer(command, writer) + "\n");
                        writer.flush();
                    }
               // }

            }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }

    public static String getAnswer(String command, Writer w) throws IOException {
        String answer = null;
        switch (command) {
            case "time":
                answer = Clock.time();
                break;
            case "date":
                answer = Clock.date();
                break;
            default:
                w.write("end \n");
                w.flush();
                socket.close();
        }
        return answer;
    }
}
