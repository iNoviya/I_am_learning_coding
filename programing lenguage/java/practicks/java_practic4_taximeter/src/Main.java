import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Taximeter");

        final int STARTED_COST = 10;
        final float UNIT_COST = 2.2f;
        final int MIN_COST = 20;

        System.out.println("How many kilometers did you travel by taxi? ");
        Scanner inputDistance = new Scanner(System.in);
        int distance = inputDistance.nextInt();

        double totalPrice = STARTED_COST + ( distance * UNIT_COST);

        if (totalPrice < 20){
            System.out.println( "Taxi price is 20 TL");
        } else {
            System.out.println( "Taxi price is " + totalPrice);
        }

    }
}