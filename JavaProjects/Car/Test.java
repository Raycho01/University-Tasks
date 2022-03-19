package Car;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] autoHouseSofia = new Car[2];
        autoHouseSofia[0] = new Car();
        autoHouseSofia[1] = new Car();

        autoHouseSofia[0].brand = "Toyota";
        autoHouseSofia[0].model = "Celica";
        autoHouseSofia[0].color = "grey";
        autoHouseSofia[0].horsePower = 143;
        autoHouseSofia[0].typeEngine = "benzin";
        autoHouseSofia[0].gearbox = "manual";

        autoHouseSofia[1].brand = "Seat";
        autoHouseSofia[1].model = "Ibiza";
        autoHouseSofia[1].color = "grey";
        autoHouseSofia[1].horsePower = 130;
        autoHouseSofia[1].typeEngine = "benzin";
        autoHouseSofia[1].gearbox = "manual";

        Car[] autoHouseVarna = new Car[5];
        autoHouseVarna[0] = new Car("Toyta", "Supra", "orange", 290, "benzin", "manual");
        autoHouseVarna[1] = new Car("Honda", "Civic", "blue", 180, "benzin", "manual");
        autoHouseVarna[2] = new Car("Honda", "Civic", "blue", 180, "benzin", "manual");
        autoHouseVarna[3] = new Car("Seat", "Leon", "black", 230, "diesel", "automatic");
        autoHouseVarna[4] = new Car("Ford", "Focus", "red", 90, "gas", "manual");

        //Car[] searchedBrand = Car.findByChar(autoHouseVarna, 'H');
        //Car[] alphabetCars = Car.sortCars(autoHouseVarna, "down");
        Car[] cleanedCars = Car.cleanCars(autoHouseVarna);
        Car.printInfo(cleanedCars);


    }
}
