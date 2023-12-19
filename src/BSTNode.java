class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;
    BSTNode(int val) { this.val = val; }
    BSTNode(int val, BSTNode left, BSTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return ""+val;
    }
}