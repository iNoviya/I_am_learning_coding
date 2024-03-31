import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> fibonacciSeries = new ArrayList<>();

        System.out.println("How many elements do you want us to show in the Fibonacci series?");
        Scanner input = new Scanner(System.in);
        int digit = input.nextInt();

        if (digit < 1) {
            System.out.println("There is no Fibonacci number.");
        } else {
            fibonacciSeries = Fibonacci(digit);

            for (int i = 0 ; i < digit; i++){
                System.out.print(fibonacciSeries.get(i) +" ");
            }
        }


    }

    public static List<Integer> Fibonacci (int event){
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);

        for (int i = 2; i < event; i++) {
            fibonacci.add(fibonacci.get(i-1)+fibonacci.get(i-2));
        }
        return fibonacci;
    }
}