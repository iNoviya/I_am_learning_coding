public class Main {
    public static void main(String[] args) {

        System.out.println("java exercise 12 generic");

        NumericBox<Integer> intBox = new NumericBox<>(2,7);
        System.out.println(intBox.intAdd());

        NumericBox<Double> doubleBox2 = new NumericBox<>(2.0,7.0);
        System.out.printf("addition result is %.2f",doubleBox2.doubleAdd());

    }
}

class NumericBox <T extends Number> {
    T value1;
    T value2;
    NumericBox(T value1 ,T value2 ) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public double doubleAdd() {
        return value1.doubleValue() + value2.doubleValue();
    }
    public int intAdd(){
        return value1.intValue() + value2.intValue();
    }
}