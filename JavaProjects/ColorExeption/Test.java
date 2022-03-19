package ColorExeption;

public class Test {
    public static void main(String[] args) {

        Car newCar = new Car("red", 120, false);
        try {
            checkColor(newCar);
        }
        catch (ColorException e){
            System.out.println(e.getMessage());
        }
        catch (SpeedException e){
            System.out.println(e.getMessage());
        }
        catch (ElectricException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("End of program.");
        }


    }

    public static void checkColor(Car car) throws ColorException, SpeedException, ElectricException{

            if (car.getColor().equals("yellow")){
                throw new ColorException("The car can't be yellow.");
            }
            else {
                System.out.println("This car is not yellow.");
            }

            if (car.getSpeed() > 150){
                throw new SpeedException();
            }
            else {
                System.out.println("Good speed.");
            }

            if (!car.isElectric()){
                throw new ElectricException("This is not an electric car.");
            }
            else {
                System.out.println("This is an electric car.");
            }

        }

    }
