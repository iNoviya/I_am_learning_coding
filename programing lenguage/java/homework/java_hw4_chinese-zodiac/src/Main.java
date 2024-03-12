import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("chinese zodiac");

        int year;

        Scanner inp = new Scanner(System.in);
        System.out.println("What year are u in");
        year = inp.nextInt();

        int modYear = year % 12;

        if (modYear == 0){
            System.out.println("You are in Monkey Chinese's zodiac years");
        } else if (modYear == 1) {
            System.out.println("You are in Rooster Chinese's zodiac years");
        } else if (modYear == 2) {
            System.out.println("You are in Dog Chinese's zodiac years");
        } else if (modYear == 3) {
            System.out.println("You are in Pig Chinese's zodiac years");
        } else if (modYear == 4) {
            System.out.println("You are in Rat Chinese's zodiac years");
        } else if (modYear == 5) {
            System.out.println("You are in Ox Chinese's zodiac years");
        } else if (modYear == 6) {
            System.out.println("You are in Kaplan Chinese's zodiac years");
        } else if (modYear == 7) {
            System.out.println("You are in Rabbit Chinese's zodiac years");
        } else if (modYear == 8) {
            System.out.println("You are in Dragon Chinese's zodiac years");
        } else if (modYear == 9) {
            System.out.println("You are in Snake Chinese's zodiac years");
        } else if (modYear == 10) {
            System.out.println("You are in Horse Chinese's zodiac years");
        } else {
            System.out.println("You are in Sheep Chinese's zodiac years");
        }


    }
}