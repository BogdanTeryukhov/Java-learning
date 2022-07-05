import java.util.Arrays;

public class MyStack {
    private int size;
    private int[] stack;
    private int top;

    public MyStack(int n) {
        size = n;
        stack = new int[size];
        top = 0;
    }

    public int Pop(){
        if (isEmpty()){
            System.out.println("Пусто");
            return 0;
        }
        top--;
        return stack[top] = 0;
    }

    public void Push(int elem){
        if (isFull()){
            System.out.println("Переполнен");
            return;
        }
        stack[top] = elem;
        top++;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public String toString(){
        return Arrays.toString(stack);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Pop();
        stack.Push(4);
        stack.Push(5);
        stack.Pop();
        stack.Push(5);
        stack.Push(6);

        System.out.println(stack);
    }
}
