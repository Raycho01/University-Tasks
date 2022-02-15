package MySecondServer;
import java.net.*;
import java.io.*;

public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String adress, int port){

        try {
            socket = new Socket(adress, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());

        } catch (IOException i) {
            System.out.println(i);
        }

        String line = "";

        while (!(line.equals("over"))){
            try {
                if (line != null){
                    line = input.readLine();
                }
                else {
                    System.out.println("Reading error.");
                    break;
                }
                output.writeUTF(line);
            }
            catch (IOException i){
                System.out.println(i);
            }
        }

        try {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

    }

}
