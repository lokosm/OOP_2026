public class Trapezoid extends Shape {
    private double a;
    private double b;
    private double c;
    private double d;
    private double height;

    public Trapezoid(double a, double b, double c, double d, double height) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.height = height;
    }
    public double area() {
        return (a + b) * height / 2;
    }
    public double p() {
        return a + b + c + d;
    }
    
}
