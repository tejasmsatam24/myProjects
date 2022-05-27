import java.util.LinkedList;
import java.util.Queue;

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

    public static void insert(Node root, int key){
        if(root == null){
            root = new Node(key);
            return;
        }

         Node temp = root;

        Queue <Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                q.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
            }else{
                q.add(temp.right);
            }

        }

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

        System.out.println("Performing Insertion....");
        insert(tree.root, 12);

        System.out.println("TADA!! 12 was added....");

        System.out.println("Performing Inorder Treversal....");
        inorderTreversal(tree.root);

    }
}