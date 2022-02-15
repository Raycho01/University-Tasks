package RegularExpressions;

public class Test {
    public static void main(String[] args) {

        String carNumber1 = "AA1234BB";
        String carNumber2 = "aa1234bb";
        String carNumber3 = "12DD2";
        String carNumber4 = "CO1133AB";

        CarNumberValidator validator = new CarNumberValidator();

        System.out.println(validator.validateCarNumber(carNumber1));
        System.out.println(validator.validateCarNumber(carNumber2));
        System.out.println(validator.validateCarNumber(carNumber3));
        System.out.println(validator.validateCarNumber(carNumber4));

    }
}
