import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculating circle's area and periöeter ");
        final double PI = 3.141;

        System.out.println("Enter circle's radius ");
        double area, perimeter;

        Scanner  inputRadius = new Scanner(System.in);
        int radius = inputRadius.nextInt();
        area = Math.pow(radius,2) * PI;
        perimeter = 2 * PI * radius;

        System.out.println("circle's area is :" + area);
        System.out.println("circle's perimeter is :" + perimeter);

        System.out.println("Area calculation for a circle segment whose central angle is known.");
        System.out.println("What should be the central angle of the circle with radius :"+ radius + "?");

        Scanner inputCenterAngle = new Scanner(System.in);
        int centerAngle = inputCenterAngle.nextInt();
        double sliceArea = area * ((double) centerAngle / 360);
        System.out.println("Slice circle's area is = "+ sliceArea);
    }
}