import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList {
    private Node head;
    private int sizeOfLinkedList;

    public void add(int value){
        if (head == null){
            this.head = new Node(value);
        }else{
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        sizeOfLinkedList++;
    }


    public void remove(int index){
        if (index==0){
            head = head.getNext();
            sizeOfLinkedList--;
            return;
        }
        int pos = 0;
        Node temp = head;

        while (temp != null){
            if (pos + 1 == index){
                temp.setNext(temp.getNext().getNext());
                sizeOfLinkedList--;
                return;
            }else{
                temp = temp.getNext();
                pos++;
            }
        }
    }

    //Не доделано!!
    public void addFirst(int value){
        Node temp = new Node(value);
        temp.setNext(head);
        System.out.println(temp);
    }

    public int get(int index){
        int ind = 0;
        Node temp = head;
        while (ind != index){
            temp = temp.getNext();
            ind++;
        }
        return temp.getValue();
    }

    public String toString(){
        int[] array = new int[sizeOfLinkedList];
        int index = 0;
        Node temp = head;

        while (temp != null){
            array[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(array);
    }

    //Test function
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);list.add(2);list.add(5);list.add(7);

        System.out.println(list);
        list.addFirst(5);
        System.out.println(list);
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value){
            setValue(value);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
