import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private LinkedList<Integer> stack;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        stack = new LinkedList<>();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(stack.isEmpty())
            stack.add(iterator.next());
        return stack.getFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if(stack.isEmpty())
            stack.add(iterator.next());
        return stack.pop();
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[] {1, 2 };
        PeekingIterator pi = new PeekingIterator(Arrays.stream(ints).iterator());
        System.out.println(pi.hasNext());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
    }
}
