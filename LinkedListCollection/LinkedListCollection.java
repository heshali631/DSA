import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A minimal singly-linked list that supports:
 *  - add to front (O(1))
 *  - contains (O(n))
 *  - remove first occurrence (O(n))
 *  - iteration (forward)
 */
public class LinkedListCollection<T> implements Iterable<T> {
    /** Node class for singly-linked list */
    private static class Node<T> {
        T v;            // stored value
        Node<T> next;   // pointer to next node
        Node(T v){ this.v = v; }
    }

    private Node<T> head; // first node (null when empty)
    private int n;        // size counter

    // @return number of items 
    public int size(){ return n; }

    // @return true when no nodes exist 
    public boolean isEmpty(){ return n == 0; }

    /**
     * Insert at the front in O(1).
     * New head points to previous head.
     */
    public void add(T x){
        Node<T> p = new Node<>(x);
        p.next = head;
        head = p;
        n++;
    }

    // @return whether x exists using equals (handles nulls) 
    public boolean contains(T x){
        for (T v: this)
            if ((v == null && x == null) || (v != null && v.equals(x)))
                return true;
        return false;
    }

    /**
     * Remove first node equal to x (if present).
     * @return true if an element was removed
     */
    public boolean remove(T x){
        Node<T> prev = null, cur = head;
        while (cur != null){
            boolean match = (cur.v == null && x == null) || (cur.v != null && cur.v.equals(x));
            if (match){
                // bypass cur
                if (prev == null) head = cur.next; else prev.next = cur.next;
                n--;
                return true;
            }
            prev = cur; cur = cur.next;
        }
        return false;
    }

    // Forward iterator from head to null 
    @Override public Iterator<T> iterator(){
        return new Iterator<T>(){
            Node<T> cur = head;
            public boolean hasNext(){ return cur != null; }
            public T next(){
                if (cur == null) throw new NoSuchElementException();
                T v = cur.v; cur = cur.next; return v;
            }
        };
    }

    // Small demo
    public static void main(String[] args){
        LinkedListCollection<String> list = new LinkedListCollection<>();
        list.add("c"); list.add("b"); list.add("a"); // a b c (because we add to front)
        System.out.println(list.contains("b")); // true
        list.remove("b");
        for(String s: list) System.out.print(s + " "); // a c
    }
}
