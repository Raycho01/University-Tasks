package RedHomework;

public class Car implements RedThings{

    protected String brand;
    protected String model;
    protected String color;

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public Car(String brand, String model, String color){
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public RedThings[] getRed(Car[] cars){

        int counter = 0;

        for (int i = 0; i < cars.length; i++){
            if (cars[i].color.equals("red")){
                counter++;
            }
        }

        RedThings[] redCars = new Car[counter];

        counter = 0;

        for (int i = 0; i < cars.length; i++){
            if (cars[i].color.equals("red")){
                redCars[counter] = cars[i];
                counter++;
            }
        }

        return redCars;

    }

}
