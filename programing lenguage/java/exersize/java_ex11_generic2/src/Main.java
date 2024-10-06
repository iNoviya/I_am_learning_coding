import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("java exercise 11 generic2");

        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};
        reverse(intArray);
        System.out.println(Arrays.toString(intArray));

        String[] stringArray = new String[]{"a", "b", "c"};
        reverse(stringArray);
        System.out.println(Arrays.toString(stringArray));

        Object[] objectArray = new Object[]{1,null, 2, 3, 4, 5, "28a"};
        reverse(objectArray);
        System.out.println(Arrays.toString(objectArray));



    }

    public static <T> void reverse (T[] array){
        int startPosition = 0;
        int endPosition = array.length - 1;
        while(startPosition < endPosition){

            T temp = array[endPosition];
            array[endPosition ] = array[startPosition];
            array[startPosition] = temp;
            startPosition++;
            endPosition--;
        }

    }
}
