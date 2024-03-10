import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculating hypotenuse");

        int aSide, bSide;
        double hypotenuse;

        System.out.println("Enter first side of triangle");
        Scanner inputASide = new Scanner(System.in);
        aSide = inputASide.nextInt();

        System.out.println("Enter first side of triangle");
        Scanner inputBSide = new Scanner(System.in);
        bSide = inputBSide.nextInt();

        hypotenuse = (double)  Math.sqrt(Math.pow(aSide,2)+Math.pow(bSide,2));
        System.out.printf("Hypotenuse equal to : %.1f \n",hypotenuse);

        double perimeter = aSide + bSide + hypotenuse;

        final double U = (double) perimeter /2;

        double area = Math.sqrt(U*(U-aSide)*(U-bSide)*(U-hypotenuse));

        System.out.println("Triangle's areas is :" + area );
        System.out.println("Triangle's perimeter is :" + perimeter);
    }
}