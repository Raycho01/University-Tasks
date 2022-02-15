package Company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //CompanyET SofiaRegion = new CompanyET("SofiaOOD", "10.07.2021", "011111", "Raycho", 1000, 15000);

        CompanyET SofiaRegion = new CompanyET();

        SofiaRegion.inputInfo(SofiaRegion);
        System.out.println(SofiaRegion.profitFinder());

    }
}
