import java.util.*;
public class Main {
    public static void main(String[] args) {

        Object o = new Animal();
        Animal a = new Mammal();
        Mammal m = new Cat();
        Cat d = new Bengal();

        m.method1();
        System.out.println(" ");
        m.method2();
        System.out.println(" ");

       // m.method3();
        d.method1();
        System.out.println(" ");
        d.method2();
        System.out.println(" ");
        d.method3();
        System.out.println(" ");
        a.method1();
        System.out.println(" ");
        a.method2();
        // a.method3();
        System.out.println(" ");
        ((Animal) o).method1();
        System.out.println(" ");
     //   ((Mammal) o).method2();

    }
}


class Animal{
    public void method1(){
        int x =2;
        System.out.print(" Animal "+(-x));
    }
    public void method2(){
        int y = 4;
        System.out.print(" Animal "+ Math.sqrt(y));
    }
}
class Mammal extends Animal{
    @Override
    public void method1(){
        int k =1;
        System.out.print(" Mammal "+k+2);
    }

    @Override
    public void method2() {
        int q = 3;
        method1();
        System.out.print(" Mammal "+(q--));
    }
}
 class Cat extends Mammal{
    @Override
    public void method1(){
        int t = 3;
        System.out.print(" Cat "+(t++));
    }
    public void method3() {
        int q = 5;
        System.out.print(" Cat "+(q--)*2);
        method1();
    }
}
 class Bengal extends Cat{
    @Override
    public void method1(){
        int g = 7;
        System.out.print(" Bengal "+Math.round(Math.pow(g++,0.33333333)));
        super.method1();
    }
    @Override
    public void method2() {
        int h = 16;
        System.out.print(" Bengal "+Math.pow(h,0.25));
        super.method2();
    }
}
