package ColorExeption;

public class ColorException extends Exception{

    String message;

    public ColorException(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
