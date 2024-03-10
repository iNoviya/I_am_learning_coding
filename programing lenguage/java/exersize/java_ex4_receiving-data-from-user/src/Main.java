import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int age;
        Scanner inputAge = new Scanner(System.in);
        age = inputAge.nextInt();
        System.out.println("user input is = "+ age);


        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("your name is : "+ name);

    }

}