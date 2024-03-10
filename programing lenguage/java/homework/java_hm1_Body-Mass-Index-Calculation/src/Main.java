import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Body Mass Index Calculation");

        System.out.println("Please enter your height (in kg)");
        Scanner inputWeight = new Scanner(System.in);
        int weight = inputWeight.nextInt();

        System.out.println("Please enter your height (in meters)");
        Scanner inputHeight = new Scanner(System.in);
        float height = inputHeight.nextFloat();

        // BMI = body mass index
        double BMI = weight / Math.pow(height,2);

        System.out.println("Your BMI score is " + BMI);
        if (BMI >= 21 && BMI <= 24 ){
            System.out.println("You are very healty");
        } else if (BMI >= 24 || BMI <= 25 ) {
            System.out.println("You should lose some weight.");
        } else {
            System.out.println("You should seen to doctor");
        }

    }
}