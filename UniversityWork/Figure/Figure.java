package Figure;

public abstract class Figure implements Calculate{
    protected String description;

    public Figure(String description){
        this.description = description;
    }

    public abstract double area();

}
