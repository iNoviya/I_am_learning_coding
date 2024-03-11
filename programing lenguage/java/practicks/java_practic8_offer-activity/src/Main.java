import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("offer activity");

        System.out.println("What is the temperature?");
        Scanner inp = new Scanner(System.in);


        int temperature = inp.nextInt();

        if (temperature < 5) {
            System.out.println("You should sky");
        } else if (temperature < 15) {
            System.out.println("You should go to cinema");
        } else if (temperature < 25) {
            System.out.println("You should go to picnic");
        } else if (temperature < 35) {
            System.out.println("You should go to swim");
        } else {
            System.out.println("DON'T GO OUTSIDE");
        }
        inp.close();
    }
}
