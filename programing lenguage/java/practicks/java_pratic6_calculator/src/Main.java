import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator");

        int x,y;
        String operator;

        System.out.println("Please enter first number");
        Scanner inputFirstNumber = new Scanner(System.in);
        x = inputFirstNumber.nextInt();

        System.out.println("Please enter operator number");
        Scanner inputOperator = new Scanner(System.in);
        operator = inputOperator.nextLine();

        System.out.println("Please enter second number");
        Scanner inputSecondNumber = new Scanner(System.in);
        y = inputSecondNumber.nextInt();


        switch ( operator){
            case "+" :
                System.out.println("x "+ operator + " y = " + (x + y) );
                break;
            case "-" :
                System.out.println("x "+ operator + " y = " + (x - y) );
                break;
            case "*" :
                System.out.println("x "+ operator + " y = " + (x * y) );
                break;
            case "/" :
                System.out.println("x "+ operator + " y = " + (x / y) );
                break;
            case "%" :
                System.out.println("x "+ "mod" + " y = " + (x % y) );
                break;
            default:
                System.out.println("Please check your input and try again" +" "+ x + " " + operator +  " " + y );
                break;
        }
    }
}