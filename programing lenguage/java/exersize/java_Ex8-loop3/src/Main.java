import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter a value");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        int temp =1;

        System.out.println("Powers of 4 that are less than the entered value.");
        while (1<2){
            temp*=4;
            if (temp<value){
                System.out.print(temp+" ");
            } else break;
        }
        temp =1;
        System.out.println("\nPowers of 5 that are less than the entered value.");
        while (1<2){
            temp*=5;
            if (temp<value){
                System.out.print(temp+" ");
            } else break;
        }
        System.out.println();
    }
}