package service.tree;

public class BinaryTree {
    private Node root;

    private int size;
    private int rank;

    public void add(int value) {
        size++;
        root = addNodeRecursive(root, value);
    }

    private Node addNodeRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.node) {
            current.left = addNodeRecursive(current.left, value);
        } else if (value > current.node) {
            current.right = addNodeRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public Node getRoot() {
        return root;
    }

    public void nodeRankTree(int i) {
        int counter = 0;
        System.out.println(checkRank(root, i, counter));
    }

    private int checkRank(Node root, int i, int counter) {
        if (root.node == i) {
            rank=++counter;
        }
        if (root.left != null && root.node > i) {
            checkRank(root.left, i, ++counter);
        }
        if (root.right != null && root.node < i) {
            checkRank(root.right, i, ++counter);
        }
        return rank;
    }

    public int size(){
        return size;
    }

    public void print() {
        printRecursive(root);
    }

    public static void checkTheRank(BinaryTree tree, int i) {
        tree.nodeRankTree(6);
    }

    private void printRecursive(Node root) {
        System.out.println(" "+root.node+", ");
        if (root.left != null) {
            System.out.println("left: "+root.left.node);
            printRecursive(root.left);
        }
        if (root.right != null) {
            System.out.print("right: "+root.right.node);
            printRecursive(root.right);
        }
    }
}
