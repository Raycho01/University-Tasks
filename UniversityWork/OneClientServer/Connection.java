package OneClientServer;

import java.io.*;
import java.net.Socket;

public class Connection implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;


    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String username = bufferedReader.readLine();

            bufferedWriter.write("SERVER: Hello, " + username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String message = "";

            while (!(message.equalsIgnoreCase("BYE"))) {

                message = bufferedReader.readLine();
                System.out.println(username + ": " + message);
                bufferedWriter.write("SERVER: Message received.");
                bufferedWriter.newLine();
                bufferedWriter.flush();

            }

            System.out.println("-----------Client disconnected-----------");

        } catch (IOException e) {
            Server.closeEverything(socket, bufferedWriter, bufferedReader);
        }

    }
}

