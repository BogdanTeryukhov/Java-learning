import java.util.Scanner;

public class MultiplicationOfNumbers {

    public static boolean MultiplicationOfDigits(int count, int N){
        int multi = 1;
        int temp = count;

        while (count > 0){
            temp%=10;
            count/=10;

            multi*=temp;
            temp = count;
        }
        return N == multi;
    }

    public static boolean isSimple(int N){
        for (int i = 2; i < N / 2; i++) {
            if (N % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();



        int count = N + 1;

        if (N < 10 || isSimple(N)){
            System.out.println(N);;
        }else{
            while (!MultiplicationOfDigits(count,N)) {
                count++;
            }
            System.out.println(count);
        }
    }
}
