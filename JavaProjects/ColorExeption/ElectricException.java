package ColorExeption;

public class ElectricException extends Exception{

    String message;

    public ElectricException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
