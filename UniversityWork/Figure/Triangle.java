package Figure;

public class Triangle extends Figure{
    protected double a;
    protected double b;

    public Triangle(String description, double a, double b){
        super(description);
        this.a = a;
        this.b = b;
    }

    public double area(){
        return (a*b)/2;
    }

}
