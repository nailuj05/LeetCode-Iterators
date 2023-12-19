package BST;

import java.util.Arrays;
import java.util.LinkedList;

class BSTIterator {

    public LinkedList<BSTNode> nodeStack;

    public BSTIterator(BSTNode n) {
        if(n == null) return;

        nodeStack = new LinkedList<>();

        updateStack(n);
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    public int next() {
        var c = nodeStack.pop();

        updateStack(c.right);

        return c.val;
    }

    public void updateStack(BSTNode node){
        while(node != null){
            nodeStack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        BSTNode root;
        BSTIterator bSTIterator;
        root = new BSTNode(1, null, new BSTNode(2));

        bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(Arrays.toString(bSTIterator.nodeStack.toArray()));

        System.out.println("-------------------------");

        root = new BSTNode(7, new BSTNode(3), new BSTNode(15, new BSTNode(9), new BSTNode(20)));

        bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());    // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
        System.out.println(Arrays.toString(bSTIterator.nodeStack.toArray()));

        System.out.println("-------------------------");

        root = new BSTNode(2, new BSTNode(1), null);

        bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(Arrays.toString(bSTIterator.nodeStack.toArray()));
    }
}