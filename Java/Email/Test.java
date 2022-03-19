package Email;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws NotEmailEception, IOException {

        //User.addUser("ivan@gmail.com", "12345678");
        File file = new File("C:\\Users\\raich\\Desktop\\emails_list.txt");
        System.out.println(User.searchUser(file, "raycho@gmail.com", "abc123"));

    }
}
