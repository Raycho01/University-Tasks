package Email;

public class NotEmailEception extends Exception{

    String message;

    public NotEmailEception(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
