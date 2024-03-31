import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i < 100; i++) {
            if (checkPrime(i)){
                System.out.print(i + ", ");
            }
        }

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (checkPrime(number)){
            System.out.println(number + " is prime number");
        } else System.out.println(number + " isn't prime number");

    }

    public static boolean checkPrime (int number){

        if (number <= 1) return false;

        for (int i = 2; i < number ; i++) {
            if (number % i == 0)  return false;
        }
        return true;
    }
}