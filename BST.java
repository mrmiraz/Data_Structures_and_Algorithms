public class Node {
    int data;
    Node left, right;
    
     public Node(int data){
        this.data = data;
        left = right = null;
    }
}


public class Bst {

    Node root;
    public void insert(int data) {
        root = insertHelper(root, data);
    }

    public Node insertHelper(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertHelper(root.left, data);
        } else {
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public void printInOrder(){
        System.out.print("\nIn Order: ");
        inOrder(root);
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void printPreOrder(){
        System.out.print("\nPre Order: ");
        preOrder(root);
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void printPostOrder(){
        System.out.print("\nPost Order: ");
        postOrder(root);
    }
    
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public void search(int data){
        searchHelper(root, data);
    }
    public void searchHelper(Node root, int data){
        if(root == null){
            System.out.println(data + " is not found!");
           return;
        }
        if(root.data == data){
            System.out.println(root.data + " is found!");
            return;
        }
        if(data < root.data){
            searchHelper(root.left, data);
        }
        else{
            searchHelper(root.right, data);
        }
        
    }
    
    public Node remove(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.left = remove(root.left, data);
            
        }
        else if(data > root.data){
            root.right = remove(root.right, data);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if( root.right == null){
                return root.left;
            }
            else{
                int rMin = rMin(root.right);
                root.data = rMin;
                root.right = remove(root.right, rMin);
                return root;
            }
        }
        return root;
    }
    public int rMin(Node root){
        if(root.left == null){
            return root.data;
        }
        else{
            return rMin(root.left);
        }
        
    }
//https://www.youtube.com/watch?v=5_AZcOOc-kM
