public class Main {
    public class Node{
        int value;//value in notes to make more sense
        Node left;//remember how it is set up
        Node right;//nodes left to right root middle
        Node(int value){
            this.value = value;
        }

        public class binaryTree{
            Node root;
        }
        void preorder(Node node){
            if(node==null){
                return;
            }
            System.out.print(node.value+" ");//node not data for all
            preorder(node.left);//node not data
            preorder(node.right);
        }

        void postorder(Node node){
            if(node==null){
                return;
            }
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value+" ");
        }
    }
    public class binaryTree{
        Node root;
    }
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+"");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"");

    }
    public class binraryTree{
        Node root;
    }
    public void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value+"");
        inorder(node.right);
    }
}
