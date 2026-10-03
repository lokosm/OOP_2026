public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D( x + other.x, y + other.y, z + other.z);
    }

    public Vector3D mult(double number) {
        return new Vector3D(x * number, y * number, z * number);   
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public void print() {
        System.out.println(x + ", " + y + ", " + z);
    }

    public double scalarProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }
 
}
