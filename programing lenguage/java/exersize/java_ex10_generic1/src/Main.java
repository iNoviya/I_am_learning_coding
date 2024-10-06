import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("java exercise 10 generic 1");

        System.out.println("test for integer variables");
        Box<Integer> boxInteger = new Box<>(35);
        boxInteger.setItem(25);
        System.out.println(boxInteger.getItem());
        boxInteger.printBoxInfo();

        System.out.println("test for String variables");
        Box<String> boxString = new Box<>("Hello");
        System.out.println(boxString.getItem());
        boxString.setItem(" bay bay");
        boxString.printBoxInfo();

        System.out.println("test for object variables");
        Box<Object> boxObject = new Box<>(null);
        System.out.println(boxObject.getItem());
        boxObject.setItem(25);
        System.out.println(boxObject.getItem());
        boxObject.setItem(" bay bay");
        boxObject.printBoxInfo();

        Scanner scanner = new Scanner(System.in);
        Box<Integer> userInput = new Box<>(scanner.nextInt());
        userInput.printBoxInfo();


    }
}