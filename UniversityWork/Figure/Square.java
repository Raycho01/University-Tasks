package Figure;

public class Square extends Figure {
    protected double a;

    public Square(String description, double a){
        super(description);
        this.a = a;
    }

    public double area(){

        return a*a;

    }

}
