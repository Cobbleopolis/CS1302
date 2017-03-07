package geometry;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2, 6, 5, "white", false);
        System.out.println(triangle);
        /** Modifications go here**/
        System.out.println("\nModified Triangle:\n");
        triangle.setSide1(1);
        triangle.setSide2(1.5);
        triangle.setSide3(1);
        triangle.setColor("yellow");
        triangle.setFilled(true);
        System.out.println(triangle);
    }

}
