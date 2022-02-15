package Company;

import java.util.Scanner;

public class Company {

    Scanner scanner = new Scanner(System.in);

    protected String name;
    protected String dateOfCreation;
    protected String id;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDateOfCreation(){
        return name;
    }

    public void setDateOfCreation(String dateOfCreation){
        this.dateOfCreation = dateOfCreation;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        if(id.length() != 10){
            System.out.print("Error. Please enter a valid (10-number) id:");
            String newId = scanner.nextLine();
            setId(newId);
        }
        this.id = id;
    }

    public Company(String name, String dateOfCreation, String id){
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.id = id;
    }

    public Company(){
        this.name = "";
        this.dateOfCreation = "";
        this.id = "";
    }

}
