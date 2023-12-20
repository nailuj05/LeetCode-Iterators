package CombinationIterator;

public class CombinationIterator {
    private char[] characters;
    private int length;
    private long next;
    private long perms;

    private char[] current;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters.toCharArray();
        this.length = combinationLength;
        this.perms = binomi(this.characters.length, combinationLength);
        this.current = new char[combinationLength];
        this.next = 0;
    }

    static long binomi(int n, int k) {
        if ((n == k) || (k == 0))
            return 1;
        else
            return binomi(n - 1, k) + binomi(n - 1, k - 1);
    }

    public String next() {
        next++;


        return "";
    }

    public boolean hasNext() {
        return next < perms;
    }

    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abc", 2);
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
