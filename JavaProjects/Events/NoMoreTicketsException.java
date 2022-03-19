package Events;

public class NoMoreTicketsException extends Exception{

    protected String message;

    public NoMoreTicketsException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
