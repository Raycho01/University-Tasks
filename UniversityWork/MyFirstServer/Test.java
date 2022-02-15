package MyFirstServer;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.start(1232);
        GreetClient client = new GreetClient();
        client.startConnection("78.90.52.30", 1232);
        String response = client.sendMessage("hello server");

    }

}
