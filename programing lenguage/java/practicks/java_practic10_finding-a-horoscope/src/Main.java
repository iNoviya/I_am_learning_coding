import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Finding a horoscope");

        System.out.println("In which month were you born? Please enter in number format. ");

        Scanner inp = new Scanner(System.in);
        int month = inp.nextInt();

        System.out.println("In which day were you born? ");
        int day = inp.nextInt();

        if (month == 1){
            if (day <22 ){
                System.out.println("Your horoscope is : Capricorn:");
            } else {
                System.out.println("Your horoscope is : Aquarius:");
            }
        }   else if (month == 2) {
            if (day < 20 ){
                System.out.println("Your horoscope is : Aquarius:");
            } else {
                System.out.println("Your horoscope is : Pisces");
            }
        }   else if (month == 3) {
            if (day <21 ){
                System.out.println("Your horoscope is : Pisces");
            } else {
                System.out.println("Your horoscope is : Aries");
            }
        }   else if (month == 4) {
            if (day <21 ){
                System.out.println("Your horoscope is : Aries");
            } else {
                System.out.println("Your horoscope is : Taurus");
            }
        }   else if (month == 5) {
            if (day <22 ){
                System.out.println("Your horoscope is : Taurus");
            } else {
                System.out.println("Your horoscope is : Gemini");
            }
        }   else if (month == 6) {
            if (day <23 ){
                System.out.println("Your horoscope is : Gemini");
            } else {
                System.out.println("Your horoscope is : Cancer");
            }
        }   else if (month == 7) {
            if (day <23 ){
                System.out.println("Your horoscope is : Cancer");
            } else {
                System.out.println("Your horoscope is : Leo");
            }
        }   else if (month == 8) {
            if (day <23 ){
                System.out.println("Your horoscope is : Leo");
            } else {
                System.out.println("Your horoscope is : Virgo");
            }
        }   else if (month == 9) {
            if (day <23 ){
                System.out.println("Your horoscope is : Virgo");
            } else {
                System.out.println("Your horoscope is : Libra");
            }
        }   else if (month == 10) {
            if (day <23 ){
                System.out.println("Your horoscope is : Libra");
            } else {
                System.out.println("Your horoscope is : Scorpio");
            }
        }   else if (month == 11) {
            if (day <22 ){
                System.out.println("Your horoscope is : Scorpio");
            } else {
                System.out.println("Your horoscope is : Sagittarius");
            }
        }   else if (month == 12) {
            if (day <22 ){
                System.out.println("Your horoscope is : Sagittarius");
            } else {
                System.out.println("Your horoscope is : Capricorn");
            }
        }


    }
}