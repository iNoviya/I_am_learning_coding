import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simple sort");

        Scanner inp = new Scanner(System.in);

        int x,y,z;

        x = inp.nextInt();
        y = inp.nextInt();
        z = inp.nextInt();

        if (x < y){
            if ( y < z){
                System.out.println(z+" > "+ y + " > " + x);
            }
            else {
                if (x < z){
                    System.out.println(z+" > "+ x + " > " + y);
                }
                else {
                    System.out.println(x+" > "+ z + " > " + y);
                }
            }
        }
        else {
            if ( x < z){
                System.out.println(z+" > "+ x + " > " + y);
            }
            else {
                if (y < z){
                    System.out.println(x+" > "+ z + " > " + y);
                }
                else {
                    System.out.println(x+" > "+ y + " > " + z);
                }
            }
        }

    }
}