package Company;

public class CompanyET extends Company {

    protected String ownerName;
    protected double startingMoney;
    protected double presentMoney;

    public CompanyET(String name, String dateOfCreation, String id, String ownerName, double startingMoney, double presentMoney){
        super(name, dateOfCreation, id);
        this.ownerName = ownerName;
        this.startingMoney = startingMoney;
        this.presentMoney = presentMoney;
    }

    public CompanyET(){
        this.ownerName = "";
        this.startingMoney = 0;
        this.presentMoney = 0;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public double getStartingMoney(){
        return startingMoney;
    }

    public void setStartingMoney(double startingMoney){
        this.startingMoney = startingMoney;
    }

    public double getPresentMoney(){
        return presentMoney;
    }

    public void setPresentMoney(double presentMoney){
        this.presentMoney = presentMoney;
    }

    // methods:

    protected double profitFinder(){
        return presentMoney - startingMoney;
    }

    public void inputInfo(CompanyET company){

        System.out.print("Enter name of company: ");
        String name = scanner.nextLine();
        company.setName(name);

        System.out.print("Enter date of creation: ");
        String dateOfCreation = scanner.nextLine();
        company.setDateOfCreation(dateOfCreation);

        System.out.print("Enter id (10 numbers): ");
        String id = scanner.nextLine();
        company.setId(id);

        System.out.print("Enter name of owner: ");
        String ownerName = scanner.nextLine();
        company.setOwnerName(ownerName);

        System.out.print("Enter starting money: ");
        double startingMoney = Double.parseDouble(scanner.nextLine());
        company.setStartingMoney(startingMoney);

        System.out.print("Enter money in present time: ");
        double presentMoney = Double.parseDouble(scanner.nextLine());
        company.setPresentMoney(presentMoney);

    }

}
