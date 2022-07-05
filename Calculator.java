import org.junit.Test;

public class Calculator implements Operations{
    private int[] array;

    public Calculator(int... array) {
        setArray(array);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int... array) {
        this.array = array;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(1,2,3,4,5);
        System.out.println(calculator.sum(calculator.getArray()));
        System.out.println(calculator.difference(calculator.getArray()));
        System.out.println(calculator.multiplication(calculator.getArray()));
        System.out.println(calculator.division(calculator.getArray()));
    }
}
