package ColorExeption;

public class Car {

    private String color;
    private double speed;
    private boolean electric;

    public Car(String color, double speed, boolean electric) {
        this.color = color;
        this.speed = speed;
        this.electric = electric;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }
}
