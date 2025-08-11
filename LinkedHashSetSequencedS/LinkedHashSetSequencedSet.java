import java.util.LinkedHashSet;

/**
 * A set that preserves insertion order using LinkedHashSet.
 * Same average complexities as HashSet, but iteration is predictable.
 */
public class LinkedHashSetSequencedSet<T> {
    // LinkedHashSet remembers order of insertion
    private final LinkedHashSet<T> s = new LinkedHashSet<>();

    // Add element if missing; returns true when actually added. 
    public boolean add(T x){ return s.add(x); }

    // Remove element if present; returns true when removed. 
    public boolean remove(T x){ return s.remove(x); }

    // Membership test. 
    public boolean contains(T x){ return s.contains(x); }

    // Number of elements. 
    public int size(){ return s.size(); }

    // @return whether the set is empty. 
    public boolean isEmpty(){ return s.isEmpty(); }

    //Iterable view so client can loop in insertion order. 
    public Iterable<T> items(){ return s; }

    // Demo
    public static void main(String[] args){
        LinkedHashSetSequencedSet<String> set = new LinkedHashSetSequencedSet<>();
        set.add("A"); set.add("C"); set.add("B"); // iteration: A, C, B
        for (String v : set.items()) System.out.print(v + " ");
    }
}
