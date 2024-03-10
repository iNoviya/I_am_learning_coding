public class Main {
    public static void main(String[] args) {
        System.out.println("Arithmetic operators");
        int x = 5, y = 3;
        System.out.println(x + y);
        System.out.println(x - y);
        float z = (float) x / y;
        System.out.println(z);
        System.out.println(x * y);
        System.out.println(x % y);

        System.out.println("Comparison Operators");
        int k = 5, l = 10, m = 5;
        System.out.println("k = "+ k +" ,l = "+l+" ,m = "+m);
        System.out.println(String.format("k = %d, l = %d, m = %d", k, l, m));
        System.out.println("k == m : " + (boolean)(k == m));
        System.out.println("k == l : " + (boolean)(k == l));
        System.out.println("k <= l : " + (boolean)(k >= l));
        System.out.println("k <= m : " + (boolean)(k <= m));
        System.out.println("l != m : " + (boolean)(l != m));

        System.out.println("Logical Operators");
        System.out.println("k or l == 5 : " + (boolean)((k == 5) || (l == 5)));
        System.out.println("k and m == 5 : " + (boolean)((k == 5) && (m == 5)));


        System.out.println("Condition Operator");
    }
}