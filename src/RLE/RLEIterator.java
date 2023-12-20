package RLE;

import java.util.LinkedList;

public class RLEIterator {
    private LinkedList<EncodePair> pairList;

    public RLEIterator(int[] encoding) {
        pairList = new LinkedList<>();
        for (int i = 0; i < encoding.length; i += 2) {
            pairList.add(new EncodePair(encoding[i], encoding[i+1]));
        }
    }

    public int next(int n) {
        int res = -1;



        while(!pairList.isEmpty()) {
            EncodePair p = pairList.peek();
            if(n <= p.amount) {
                res = p.value;
                p.amount -= n;
                break;
            } else {
                n -= p.amount;
            }
            pairList.pop();
        }

        return res;
    }

    class EncodePair {
        public int amount;
        public int value;

        EncodePair(int amount, int value) {
            this.amount = amount;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        RLEIterator iter = new RLEIterator(new int[] { 3, 8, 0, 9, 2, 5 });
        System.out.println(iter.next(2));
        System.out.println(iter.next(1));
        System.out.println(iter.next(1));
        System.out.println(iter.next(2));

        System.out.println("------------------------");

        iter = new RLEIterator(new int[] {  });
        System.out.println(iter.next(2));
        System.out.println(iter.next(1));

        System.out.println("------------------------");
        iter = new RLEIterator(new int[] {811,903,310,730,899,684,472,100,434,611});
        System.out.println(iter.next(358));
        System.out.println(iter.next(345));
        System.out.println(iter.next(345));
    }
}
