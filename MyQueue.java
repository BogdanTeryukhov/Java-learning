import java.util.Arrays;

public class MyQueue {


    private int capacity;
    private int head;
    private int tail;
    private int[] queue;
    private int count;


    public MyQueue(int size){
        capacity = size;
        queue = new int[capacity];
        tail = 0;
        head = 0;
        count = 0;
    }

    public void Enqueue(int element){
        queue[tail++] = element;
        count++;
        if (tail==capacity){
            tail = 0;
            count++;
            head = 0;
        }
    }

    public void Dequeue(){
        if (isQueueEmpty()){
            System.out.println("Error");
        }
        head = tail;
        queue[head++] = 0;
    }

    public boolean isQueueEmpty(){
        return count == 0;
    }

    public String toString(){
        return Arrays.toString(queue);
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Dequeue();


        System.out.println(queue);
    }
}
