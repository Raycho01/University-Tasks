package Email;

import Company.CompanyET;

import java.io.*;
import java.util.regex.Matcher;

public class User implements Validator{

    protected String nickName;
    protected String password;

    public User(String nickName, String password) throws NotEmailEception {
        boolean valid = checking(nickName);
        if (valid) {
            this.nickName = nickName;
            this.password = password;
        } else {
            throw new NotEmailEception("Not a valid email.");
        }
    }

    public boolean checking(String nickName){
        Matcher matcher = VALID_EMAIL.matcher(nickName);
        return matcher.find();
    }

    public static void addUser(String nickName, String password) throws NotEmailEception, IOException {

        User user = new User(nickName, password);

        String filePath = "C:\\Users\\raich\\Desktop\\emails_list.txt";
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file, true);

        try {
            writer.write(user.nickName + " - ");
            writer.write(user.password + "\n");
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
        finally {
            writer.flush();
        }

    }

    public static boolean searchUser(File file, String nickName, String password) throws IOException {

        FileReader freader = null;
        BufferedReader buffer = null;

        try {

            freader = new FileReader(file);
            buffer = new BufferedReader(freader);
            String currentLine = buffer.readLine();
            String[] data = currentLine.split("\n");
            System.out.println(data[1]);

            for (int i = 0; i < data.length; i++){
                if (data[i].equals(nickName + " - " + password)){
                    return true;
                }
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            freader.close();
            buffer.close();
        }

        return false;

    }



}
