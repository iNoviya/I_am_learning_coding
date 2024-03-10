import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculate avarage of score");

        int exam1, exam2;
        System.out.println("Enter your mitterm exam's score");
        Scanner scoreOne = new Scanner(System.in);
        exam1 = scoreOne.nextInt();

        System.out.println("Enter your final exam's score");
        Scanner scoreTwo = new Scanner(System.in);
        exam2 = scoreTwo.nextInt();

        float average = (float) (exam1 + exam2 ) /2;
        System.out.println("Your exam score is : "+ average);

        if (average > 60){
            System.out.println("You are pass this lesson");
        }
        else  {
            System.out.println("You aren't past the lesson");
        }
    }
}