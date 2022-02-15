package OneClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;
    private Socket socket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer(){

        while (true){

            try {
                socket = serverSocket.accept();
                System.out.println("-----------Client connected-----------");

                Connection connection = new Connection(socket);
                Thread thread = new Thread(connection);
                thread.start();


            } catch (IOException e) {
                closeSocket(socket);
            }

        }
    }

    public static void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader){

        try {
            if (socket != null){
                socket.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (bufferedReader != null){
                bufferedReader.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("-----------Client disconnected-----------");

    }

    public void closeSocket(Socket socket){

        try {
            if (socket != null){
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("-----------Client disconnected-----------");

    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        System.out.println("-----------SERVER STARTED-----------");
        server.startServer();


    }

}