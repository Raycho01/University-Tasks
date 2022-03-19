package ChatServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public Client(Socket socket, String clientUsername){
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientUsername = clientUsername;
        } catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(clientUsername);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);

            while (socket.isConnected()){
                String message = scanner.nextLine();
                bufferedWriter.write(clientUsername + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void listenForMessage(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                String message;

                while (socket.isConnected()){
                    try {
                        message = bufferedReader.readLine();
                        System.out.println(message);
                    } catch (IOException e){
                        closeEverything(socket, bufferedWriter, bufferedReader);
                    }
                }

            }
        }).start();

    }

    public void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader){

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

    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username for the chat: ");
        String username = scanner.nextLine();

        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();

    }

}
