interface Stack<T> {
    boolean isEmpty();
    void push(T data);
    void pop();

    int size();
}
public class myStack<T> extends myLinkedList<T> implements Stack<T> {

    private Node head;
    private Node tail;
    private int size;

    public myStack(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node(data);
        if(size == 0){
            newNode.next = head;
            head = newNode;
            size++;

            if(head.next == null){
                tail = head;
            }
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    @Override
    public void pop() {
        Node node = head;

        for(int i=0; i<size()-2; i++){
            node = node.next;
        }

        tail = node;
        tail.next = null;
        size--;
    }

    public String toString(){
        if(size == 0) return "[]";

        Node node = head;

        String str = "[";
        while(node.next != null){
            str += node.data + ",";
            node = node.next;
        }

        str += node.data + "]";
        return str;
    }
}
