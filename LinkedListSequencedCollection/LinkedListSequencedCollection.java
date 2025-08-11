import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Doubly-linked list with O(1) end operations:
 *  - addFirst / addLast
 *  - removeFirst / removeLast
 * Also exposes peekFirst/peekLast and supports forward iteration.
 */
public class LinkedListSequencedCollection<T> implements Iterable<T> {
    /** Node for doubly-linked list */
    private static class Node<T> {
        T v; Node<T> prev, next;
        Node(T v){ this.v = v; }
    }

    private Node<T> head, tail; // first and last nodes (null when empty)
    private int n;

    public int size(){ return n; }
    public boolean isEmpty(){ return n == 0; }

    /** Insert at the front in O(1). */
    public void addFirst(T x){
        Node<T> p = new Node<>(x);
        p.next = head;
        if (head != null) head.prev = p; else tail = p; // if empty, tail = new node
        head = p;
        n++;
    }

    /** Insert at the back in O(1). */
    public void addLast(T x){
        Node<T> p = new Node<>(x);
        p.prev = tail;
        if (tail != null) tail.next = p; else head = p; // if empty, head = new node
        tail = p;
        n++;
    }

    /** Remove and return the first element in O(1). */
    public T removeFirst(){
        if (head == null) throw new NoSuchElementException();
        T v = head.v;
        head = head.next;
        if (head != null) head.prev = null; else tail = null; // became empty
        n--;
        return v;
    }

    /** Remove and return the last element in O(1). */
    public T removeLast(){
        if (tail == null) throw new NoSuchElementException();
        T v = tail.v;
        tail = tail.prev;
        if (tail != null) tail.next = null; else head = null; // became empty
        n--;
        return v;
    }

    /** View first element without removing. */
    public T peekFirst(){
        if (head == null) throw new NoSuchElementException();
        return head.v;
    }

    /** View last element without removing. */
    public T peekLast(){
        if (tail == null) throw new NoSuchElementException();
        return tail.v;
    }

    /** Forward iterator (head -> tail). */
    @Override public Iterator<T> iterator(){
        return new Iterator<T>(){
            Node<T> cur = head;
            public boolean hasNext(){ return cur != null; }
            public T next(){ T v = cur.v; cur = cur.next; return v; }
        };
    }

    // Quick test
    public static void main(String[] args){
        LinkedListSequencedCollection<Integer> dq = new LinkedListSequencedCollection<>();
        dq.addFirst(2); dq.addLast(3); dq.addFirst(1); // 1,2,3
        System.out.println(dq.removeLast()); // 3
        System.out.println(dq.peekFirst());  // 1
    }
}
