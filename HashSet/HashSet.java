import java.util.HashSet;
import java.util.Set;

/**
 * Wrapper around Java's HashSet to demonstrate classic set operations:
 *  - add/remove/contains/size/isEmpty
 *  - union, intersection, difference (each returns a NEW set)
 * HashSet provides average O(1) for add/remove/contains.
 */
public class HashSetSet<T> {
    // We keep a single HashSet field to store elements
    private final Set<T> s = new HashSet<>();

    // Add an element (no duplicates). @return true if it was new 
    public boolean add(T x){ return s.add(x); }

    // Remove an element if present. @return true if something was removed 
    public boolean remove(T x){ return s.remove(x); }

    // Check membership 
    public boolean contains(T x){ return s.contains(x); }

    // @return number of unique elements 
    public int size(){ return s.size(); }

    // @return true if empty
    public boolean isEmpty(){ return s.isEmpty(); }

    //Expose a read/write view of the underlying set (useful for printing). 
    public Set<T> asJavaSet(){ return s; }

    /** @return a new set representing union of this and other */
    public HashSetSet<T> union(HashSetSet<T> other){
        HashSetSet<T> out = new HashSetSet<>();
        out.s.addAll(this.s);
        out.s.addAll(other.s);
        return out;
    }

    // @return a new set representing intersection of this and other 
    public HashSetSet<T> intersection(HashSetSet<T> other){
        HashSetSet<T> out = new HashSetSet<>();
        for (T x: this.s) if (other.s.contains(x)) out.s.add(x);
        return out;
    }

    // @return a new set representing (this \ other) /
    public HashSetSet<T> difference(HashSetSet<T> other){
        HashSetSet<T> out = new HashSetSet<>();
        for (T x: this.s) if (!other.s.contains(x)) out.s.add(x);
        return out;
    }

    // Mini demo
    public static void main(String[] args){
        HashSetSet<Integer> a = new HashSetSet<>();
        HashSetSet<Integer> b = new HashSetSet<>();
        a.add(1); a.add(2); a.add(3);
        b.add(3); b.add(4);

        System.out.println(a.union(b).asJavaSet());        // [1,2,3,4]
        System.out.println(a.intersection(b).asJavaSet()); // [3]
        System.out.println(a.difference(b).asJavaSet());   // [1,2]
    }
}
