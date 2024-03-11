import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("User logg in");

        System.out.println("default user name and password : \"mskarats\"  \"1234 \"");

        String userName = "mskarats";
        String userPassword = "1234";

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your user name");
        String inpUserName = input.nextLine();

        System.out.println("Please enter your password");
        String inpUserPassword = input.nextLine();

        if (inpUserName.equals(userName) && inpUserPassword.equals(userPassword)) {
            System.out.println("You have successfully logged in.");
        }
        else {
            System.out.println("Your password or username is wrong ?");
            System.out.println("Do you want to change your password ? Please press \"yes\"");

            String userAnswer = input.nextLine();
            if (userAnswer.equals("yes")) {
                System.out.println("What is your new password ");
                String newPassword = input.nextLine();

                if (newPassword.equals(inpUserPassword)) {
                    System.out.println("Please don't enter the same password, please try again");
                }
                else {
                    System.out.println("Your password has been changed successfully");
                }
            }
        }
        input.close(); // It's good practice to close the scanner
    }
}
