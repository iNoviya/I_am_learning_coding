public class Main {
    public static void main(String[] args) {
        System.out.println("java ex exercise ");

        int returningValue = comp(26, 25);

        if (returningValue == 1) {
            System.out.println("wind 1 player");
        } else if (returningValue == 0) {
            System.out.println("tie");
        } else {
            System.out.println("win second player");
        }
    }
    
    public static  <T extends Number & Comparable<T>> int comp(T a, T b) {
        return a.compareTo(b);
    }
}
