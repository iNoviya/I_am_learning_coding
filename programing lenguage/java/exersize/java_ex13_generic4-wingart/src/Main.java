import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("java exercise 13 generic using wildcard");

        Printer printer = new Printer();
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        printer.print(intList);

        List<String> stringList = Arrays.asList("one","two","three");
        printer.print(stringList);
    }
    public static <T extends Number & Comparable<T>> int compareNumbers(T num1, T num2) {
        return num1.compareTo(num2);
    }
}
class Printer {

    public void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}