//Create a class BinaryTree
public class BinaryTree {
    //Create a structure called Node. This data structure holds
    //the data and some information about it's left and write Node
    static class Node {
        //instance variable of Node class
        public int data;
        public Node left;
        public Node right;

        //constructor
        public Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public BonaryTree() {
        this.root = null;
    }

    public boolean isBSTorNOT() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTorNot(Node root, int minValue, int maxValue){
        if (root == null){
            return true;
        }

        if(root.data >= minValue && root.data <= maxValue && isBSTorNot(root.leaf, minValue, root.data) && isBSTOrNot(root.right, root.data, maxValue)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.root= new Node(100);
        bt.root.left= new Node(90);
        bt.root.right= new Node(110);
        bt.root.left.left= new Node(80);
        bt.root.lrft.right= new Node(95);
        System.out.println(bt.isBSTorNOT());
    }
}