public class myLinkedList<T> {
    public class Node {
        T data;
        Node next;


        public Node(T data){
            this.data = data;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    private Node head;
    private Node tail;

    private int size;

    public myLinkedList(){
        this.head = null;
        this.tail = null;
        this.size =- 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(T data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null){
            tail = head;
        }
    }

    public void add(T data){
        Node newNode = new Node(data);

        if(size == 0){
            addFirst(data);
        }else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void delete(int index){
        Node curr = head.next;
        Node prev = head;

        if(index == 0){
           head = prev.next;
           prev.next = null;
           size--;
           return;
        }
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }

        for(int i=1; i<index; i++){
            curr = curr.next;
            prev = prev.next;
        }

        if(index == size-1){
            tail = prev;
        }
        prev.next = curr.next;
        curr.next = null;
        size--;
    }

    public T get(int index){
        Node node = head;

        for(int i=0; i<index; i++){
            node = node.next;
        }

        return node.data;
    }

    public String toString(){
        Node node = head;

        if(head == null){
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

    public Iterator iterator(){
        return new Iterator();
    }

    class Iterator implements java.util.Iterator {
        private Node next;
        private int nextIndex;
        private Node last;

        public Iterator() {
            this.next = head;
            this.nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size();
        }
        @Override
        public T next() {
            last = next;
            next = next.next;
            nextIndex++;
            return last.data;
        }

    }
}

