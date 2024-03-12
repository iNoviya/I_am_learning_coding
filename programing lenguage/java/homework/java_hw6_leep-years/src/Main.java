import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Leep years");

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(isLeap(year));

    }

    public static boolean isLeap(int year) {
        boolean leap = false;

        if (year % 4 == 0) {
            leap = true;
            if (year % 100 == 0) {
                leap = false;
                if (year % 400 == 0) {
                    leap = true;
                }
            }
        }

        return leap;
    }
}