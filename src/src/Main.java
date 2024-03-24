import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        myLinkedList<Integer> myLL = new myLinkedList<>();
        myQueue<Integer> q = new myQueue<>();
        myStack<Integer> st = new myStack<>();

        myLL.addFirst(3);
        myLL.addFirst(5);
        myLL.add(6);
        myLL.add(7);
        var node = myLL.get(2);
        var node2 = myLL.get(1);
        myLinkedList<Integer>.Iterator li = myLL.iterator();
        for (myLinkedList<Integer>.Iterator it = li; it.hasNext(); ) {
            var ll = it.next();
            System.out.println(ll);
        }

        for(int i=0; i<10; i++){
            q.add(i);
        }

        q.poll();
        q.poll();

        var Qsize =q.size();

        for(int i=0; i<5; i++){
            st.push(i);
        }

        st.pop();
        st.pop();


        System.out.println(myLL);

        System.out.println("\n- - - - - - - - - - -\n");

        System.out.println(q);
        System.out.println(Qsize);
        System.out.println(q.isEmpty());

        System.out.println("\n- - - - - - - - - - -\n");

        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.isEmpty());
    }
}
