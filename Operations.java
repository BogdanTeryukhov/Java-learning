import java.util.Arrays;
interface Operations {
    default int sum(int... values){
        return Arrays.stream(values).sum();
    }

    default int difference(int... values){
        return Arrays.stream(values).reduce(0,(acc, b) -> acc - b);
    }

    default int multiplication(int... values){
        return Arrays.stream(values).reduce(1,(a,b) -> a * b);
    }

    default double division(int... values){
        return Arrays.stream(values).mapToDouble(a->a).reduce(2*values[0], (a,b)-> a / b);
    }
}
