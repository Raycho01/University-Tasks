package RedHomework;

public interface RedThings {

    public default RedThings getRed(Car[] cars, Apple[] apples){

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

        counter = 0;

        for (int i = 0; i < apples.length; i++){
            if (apples[i].color.equals("red")){
                counter++;
            }
        }

        RedThings[] redApples = new Apple[counter];
        counter = 0;

        for (int i = 0; i < apples.length; i++){
            if (apples[i].color.equals("red")){
                redApples[counter] = apples[i];
                counter++;
            }
        }

        return null;

    }

}
