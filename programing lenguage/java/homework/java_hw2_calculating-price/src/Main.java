import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculating total price");

        final float PEAR = 2.14f;
        final float APPLE = 3.67f;
        final float TOMATO = 1.11f;
        final float BANANA = 0.95f;
        final float EGGPLANT = 5.00f;

        int pearWeight, appleWeight, tomatoWeight, bananaWeight, eggplantWeight;

        System.out.println("How Many Kilos of Pears?");
        Scanner inputPearWeight = new Scanner(System.in);
        pearWeight = inputPearWeight.nextInt();

        System.out.println("How Many Kilos of Pears?");
        Scanner inputAppleWeight = new Scanner(System.in);
        appleWeight = inputPearWeight.nextInt();

        System.out.println("How Many Kilos of Pears?");
        Scanner inputTomatoWeight = new Scanner(System.in);
        tomatoWeight = inputPearWeight.nextInt();

        System.out.println("How Many Kilos of Pears?");
        Scanner inputBananaWeight = new Scanner(System.in);
        bananaWeight = inputPearWeight.nextInt();

        System.out.println("How Many Kilos of Pears?");
        Scanner inputEggplantWeight = new Scanner(System.in);
        eggplantWeight = inputPearWeight.nextInt();

        float totalPrice = pearWeight*PEAR +  appleWeight*APPLE + tomatoWeight*TOMATO +  bananaWeight*BANANA + eggplantWeight*EGGPLANT ;
        System.out.printf("Total Amount : %.2f", totalPrice);
    }
}