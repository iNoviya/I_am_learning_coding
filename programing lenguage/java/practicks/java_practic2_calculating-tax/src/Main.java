import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculating tax");

        float taxFree;
        float taxRate;
        float taxAmount;


        System.out.println("Please enter your amount of money!");
        Scanner inputTaxFree = new Scanner(System.in);
        taxFree = inputTaxFree.nextInt();

        if (taxFree > 0 && taxFree < 1000 ) {
            taxRate = 0.18f;
        }
        else {
            taxRate = 0.08f;
        }
        taxAmount = (float) taxRate * taxFree;
        System.out.printf("tax free price is : %.2f\n" + "tax price is : %.2f\n" + "total price is : %.2f",taxFree,taxAmount, taxFree + taxAmount);

    }
}