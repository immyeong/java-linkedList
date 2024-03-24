interface Queue<T> {
    boolean isEmpty();
    void add(T data);
    void poll();

    int size();
}
public class myQueue<T> extends  myLinkedList<T> implements Queue<T> {
    //Queue<Integer> q = new LinkedList<>();

    private Node head;
    private Node tail;
    private int size;

    public myQueue(){
        this.head = null;
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
    public void add(T data) {
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
    public void poll() {
        Node node = head;
        head = node.next;
        node.next = null;
        size--;
    }

    public String toString(){
        Node node = head;
        if(size == 0){
            return "[]";
        }

        String str = "[";
        while(node.next != null){
            str += node.data + ",";
            node = node.next;
        }

        str += node.data + "]";
        return str;
    }

}
