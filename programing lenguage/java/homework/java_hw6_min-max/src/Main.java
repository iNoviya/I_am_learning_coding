import java.util.Scanner;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("how many number will  be enter the console");
        Scanner input = new Scanner(System.in);
        int quantity = input.nextInt();

        int[] numbers = new int[quantity];

        Scanner inputNumbers = new Scanner(System.in);
        for (int i = 0; i < quantity ; i++) {
            System.out.println("please enter "+(i+1)+". number");
            int number = inputNumbers.nextInt();
            numbers[i] = number;
        }
        Arrays.sort(numbers);
        System.out.println("The biggest number is : "+ numbers[quantity-1]);
        System.out.println("The smallest number is : "+ numbers[0]);

        inputNumbers.close();




    }
}