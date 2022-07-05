import java.util.Stack;

public class MyBinaryTree{
    private Node root;

    public MyBinaryTree(){
        root = null;
    }

    public Node findNodeValue(int value){
        Node rootNode = root;

        while (rootNode.getValue() != value){
            if (value < rootNode.getValue()){
                rootNode = rootNode.getLeftChild();
            }else{
                rootNode = rootNode.getRightChild();
            }
            if (rootNode == null){
                throw new RuntimeException("Данного узла не существует");
            }
        }
        return rootNode;
    }

    public void insertNode(int value){
        Node newNode = new Node();
        newNode.setValue(value);

        if (root == null){
            root = newNode;
        }else{
            Node currentNode = root;
            Node parentNode;

            while (true){
                parentNode = currentNode;

                if(value == currentNode.getValue()){
                    return;
                }
                else if (value < currentNode.getValue()){
                    currentNode = currentNode.getLeftChild();

                    if(currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();

                    if(currentNode == null){
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void deleteNode(int value){//не доделано
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftSide = true;

        while (currentNode.getValue() != value){
            if (value < currentNode.getValue()){
                parentNode = currentNode;
                currentNode = currentNode.getLeftChild();
                isLeftSide = true;
            }else{
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
                isLeftSide = false;
            }
        }

        if (currentNode == root){
            root = null;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            if (isLeftSide){
                parentNode.setLeftChild(null);
            }else
                parentNode.setRightChild(null);
        }else if(currentNode.getLeftChild() == null){
            parentNode.setRightChild(currentNode.getRightChild());
        }
        else if(currentNode.getRightChild() == null){
            parentNode.setRightChild(currentNode.getLeftChild());
        }
        else{//только частный случай

            if (isLeftSide){
                parentNode.setRightChild(currentNode.getRightChild());
                parentNode.setLeftChild(currentNode.getLeftChild());
            }
            else{
                parentNode.setRightChild(currentNode.getLeftChild());

                Node duplicate = currentNode;
                currentNode = currentNode.getLeftChild();

                while (currentNode.getRightChild() != null){
                    currentNode = currentNode.getRightChild();
                }
                assert currentNode.value == 9;

                parentNode.getRightChild().getRightChild().setRightChild(duplicate.getRightChild());
            }
        }
    }

    public void printTree() { // метод для вывода дерева в консоль`
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (!isRowEmpty) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insertNode(6);
        tree.insertNode(10);
        tree.insertNode(12);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(11);
        tree.insertNode(3);
        tree.insertNode(1);
        tree.insertNode(9);

        //tree.deleteNode(9);
        tree.deleteNode(10);
        tree.printTree();

        Node findNode = tree.findNodeValue(1);
        findNode.printNode();
    }


    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void printNode(){
            System.out.println("Узел имеет значение " + value);
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + '}';
        }
    }
}