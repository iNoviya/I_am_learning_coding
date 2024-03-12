import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Flight ticket price calculation");


        final float UNIT_PRICE = 0.1f;
        float totalPrice;

        int distance;
        int age;
        float discount = 0f;

        Scanner inp = new Scanner(System.in);

        System.out.println("Will you buy a one-way or two-way ticket? Press 1 for one-way, press 2 for two-way.");
        int wayType = inp.nextInt();


        System.out.println("What is the distance between each location, we will cover?");
        distance = inp.nextInt();

        System.out.println("How old are you?");
        age = inp.nextInt();

        if (age < 0 || distance < 0 || (wayType !=1 && wayType != 2) ){
            System.out.println("You entered incorrect data? Please try again?");
            System.exit(0);
        }
        totalPrice = distance * UNIT_PRICE;

        if (age < 12 ){
            discount = (float) (totalPrice * 0.5);
        } else if (age < 24) {
            discount = (float) (totalPrice * 0.1);
        } else if (age < 65){
            discount += 0;
        } else {
            discount = (float) (totalPrice * 0.3);
        }

        totalPrice -=discount;
        if (wayType == 1){
            totalPrice += 0;
        } else {
            totalPrice *= 0.8f;
            totalPrice *= 2;

        }
        System.out.println("Your price is : " + totalPrice);





        inp.close();
    }
}