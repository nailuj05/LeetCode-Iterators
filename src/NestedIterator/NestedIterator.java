package NestedIterator;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> flatStack;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatStack = new LinkedList<>();
        pushAll(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger current = flatStack.pop();

        while(!current.isInteger()){
            pushAll(current.getList());
            current = flatStack.pop();
        }

        return current.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !flatStack.isEmpty();
    }

    public void pushAll(List<NestedInteger> l) {
        for (int i = l.size() - 1; i >= 0; i--) {
            NestedInteger n = l.get(i);
            if(n.isInteger())
                flatStack.push(n);
            else
                pushAll(n.getList());
        }
    }
    
    public static void main(String[] args) {
        LinkedList<NestedInteger> l = new LinkedList<>();

        l.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return new ArrayList<>(1);
            }
        });

        var iter = new NestedIterator(l);
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
    }
}
