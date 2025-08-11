import java.util.PriorityQueue;

/**
 * A thin wrapper around Java's PriorityQueue configured as a min-heap.
 * - Natural ordering defines priority (smallest first).
 * - offer/peek/poll are O(log n) except peek which is O(1).
 */
public class PriorityQueueQueue<T extends Comparable<T>> {
    // PriorityQueue is a binary heap by default (min-heap for natural order)
    private final PriorityQueue<T> pq;

    /** Construct an empty min-heap priority queue. */
    public PriorityQueueQueue(){
        pq = new PriorityQueue<>();
    }

    /** @return current number of elements */
    public int size(){ return pq.size(); }

    /** @return true if the queue has no elements */
    public boolean isEmpty(){ return pq.isEmpty(); }

    /** Insert an element with its natural priority. */
    public void offer(T x){ pq.offer(x); }

    /** Look at the minimum element without removing it (null if empty). */
    public T peek(){ return pq.peek(); }

    /** Remove and return the minimum element (null if empty). */
    public T poll(){ return pq.poll(); }

    // Demo
    public static void main(String[] args){
        PriorityQueueQueue<Integer> q = new PriorityQueueQueue<>();
        q.offer(5); q.offer(1); q.offer(3);
        System.out.println(q.poll()); // 1
        System.out.println(q.peek()); // 3
        System.out.println(q.size()); // 2
    }
}
