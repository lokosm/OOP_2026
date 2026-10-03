public class Square extends Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }
    public double area() {
        return side * side;
    }
    public double p() {
        return 4 * side;
    }
    
}
