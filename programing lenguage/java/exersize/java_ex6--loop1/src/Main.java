import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter e number");
        int value = input.nextInt();
        int total = 0;
        int average = 0;

        for (int i = 0; i < value + 1 ; i++) {
            if (i % 12 == 0){
                total+=i;
            }
        }
        average = total / (value / 12);

        System.out.println("The arithmatic mean of the numbers from 0 to "+ value + " that are divisible by 3 and 4 is: " + average );

    }
}