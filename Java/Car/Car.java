package Car;

public class Car {

    protected String brand;
    protected String model;
    protected String color;
    protected double horsePower;
    protected String typeEngine;
    protected String gearbox;

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
    public double getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(double horsePower){
        this.horsePower = horsePower;
    }
    public String getTypeEngine(){
        return typeEngine;
    }
    public void setTypeEngine(String typeEngine){
        this.typeEngine = typeEngine;
    }
    public String getGearbox(){
        return gearbox;
    }
    public void setGearbox(String gearbox){
        this.gearbox = gearbox;
    }

    public Car(String brand, String model, String color, double horsePower, String typeEngine, String gearbox){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.typeEngine = typeEngine;
        this.gearbox = gearbox;
    }

    public Car(){
        brand = "";
        model = "";
        color = "";
        horsePower = 0;
        typeEngine = "";
        gearbox = "";
    }

    public static Car[] findByChar(Car[] cars, char ch){

        int counter = 0;

        for (int i = 0; i < cars.length; i++){
            if (cars[i].brand.charAt(0) == ch){
                counter++;
            }
        }

        Car[] filteredCars = new Car[counter];

        for (int i = 0; i < cars.length; i++){
            if (cars[i].brand.charAt(0) == ch){
                for (int j = 0; j < counter; j++){
                    filteredCars[j] = cars[i];
                }
            }
        }

        return filteredCars;
    }

    public static void printInfo(Car[] cars){

        for (int i = 0; i < cars.length; i++){
            System.out.println("Brand: " + cars[i].brand);
            System.out.println("Model: " + cars[i].model);
            System.out.println("Color: " + cars[i].color);
            System.out.println("Horse power: " + cars[i].horsePower);
            System.out.println("Type of engine: " + cars[i].typeEngine);
            System.out.println("Gearbox: " + cars[i].gearbox);
            System.out.println();
        }

    }

    public static Car[] sortCars(Car[] cars, String type){

        Car temp;

        if (type.equals("down")){

            for (int i = 0; i < cars.length; i++){
                for (int j = i+1; j < cars.length; j++){
                    if (cars[i].brand.charAt(0) > cars[j].brand.charAt(0)){
                        temp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = temp;
                    }
                }
            }

        }
        else if (type.equals("up")){

            for (int i = 0; i < cars.length; i++){
                for (int j = i+1; j < cars.length; j++){
                    if (cars[i].brand.charAt(0) < cars[j].brand.charAt(0)){
                        temp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = temp;
                    }
                }
            }

        }
        else {
            System.out.println("Wrong input");
            return null;
        }

        return cars;

    }

    public static Car[] cleanCars(Car[] cars){

        int c = 0;

        for (int i = 0; i < cars.length; i++){
            for (int j = i+1; j < cars.length; j++){
                if (cars[i].brand.equals(cars[j].brand) && cars[i].model.equals(cars[j].model) && cars[i].color.equals(cars[j].color) && cars[i].horsePower == cars[j].horsePower && cars[i].typeEngine.equals(cars[j].typeEngine) && cars[i].gearbox.equals(cars[j].gearbox)){
                    c = i;
                    break;
                }
            }
        }

        cars[c].brand = "";
        cars[c].model = "";
        cars[c].color = "";
        cars[c].horsePower = 0;
        cars[c].typeEngine = "";
        cars[c].gearbox = "";
        return cars;

    }



}
