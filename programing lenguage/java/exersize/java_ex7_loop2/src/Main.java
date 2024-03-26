import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Java ex7 loop2");
        int i =0;
        int total = 0;
        while (1<2){
            Scanner input = new Scanner(System.in);
            int value = input.nextInt();
            if (value % 4 == 0){
                i++;
                total+=value;
            }
            if (value % 2 == 1) break;
        }
        System.out.println("The sum of numbers divisible by 4 is: "+ total) ;
    }
}