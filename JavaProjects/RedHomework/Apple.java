package RedHomework;

public class Apple implements RedThings{

    protected double weight;
    protected String color;

    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public Apple(double weight, String color){
        this.weight = weight;
        this.color = color;
    }



}
