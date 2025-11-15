
    public class Main {
        private Node root;

        private class Node {
            Node left;
            Node right;
            int data;

            public Node(int newData) {
                left = null;
                right = null;
                data = newData;
            }
        }
        public void BinarySearchTree() {
            root = null;
        }

        public void printTree() {
            printTree(root);
            System.out.println();
        }
        private void printTree (Node node){
            if (node == null) return;
            printTree(node.left);
            printTree(node.right);
            System.out.print(node.data + "");
        }

    }
