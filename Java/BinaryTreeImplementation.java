class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = null; 
        right = null;
    }
}

class BinaryTreeImplementation{
    Node root;

    public static void inorderTreversal(Node root){
        if (root == null){
            return;
        }

        inorderTreversal(root.left);
        System.out.print(root.data);
        inorderTreversal(root.right);
    }

    public static void preorderTreversal(Node root){
        if(root == null)
        return;

        System.out.print(root.data);
        preorderTreversal(root.left);
        preorderTreversal(root.right);
    }

    public static void postorderTreversal(Node root){
        if(root == null)
        return;

        postorderTreversal(root.left);
        postorderTreversal(root.right);
        System.out.print(root.data);
    }



    public static void main(String[] args){
        BinaryTreeImplementation tree = new BinaryTreeImplementation();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);   
        
        System.out.println("The tree was successfully created....");

        System.out.println("Performing Inorder Treversal....");
        inorderTreversal(tree.root);

        System.out.println("Performing Preorder Treversal....");
        preorderTreversal(tree.root);

        System.out.println("Performing Postorder Treversal....");
        postorderTreversal(tree.root);

    }
}