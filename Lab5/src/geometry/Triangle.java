package geometry;

public class Triangle extends GeometricObject {
    /** Private instance fields**/
    private double side1;
    private double side2;
    private double side3;

    /** Constructors */
    public Triangle() {
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**get and set methods*/

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }


    /** Implement the abstract method findArea in GeometricObject */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }


    /** Implement the abstract method getPerimeter in GeometricObject **/
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /** Override the toString method in GeometricObject **/
    @Override
    public String toString() {
        return super.toString() +
                "\nTriangle: " +
                "side1 = " + side1 +
                " side2 = " + side2 +
                " side3 = " + side3 +
                "\nArea: " + getArea() +
                "\nPerimeter: " + getPerimeter();
    }


}
