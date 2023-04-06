package Tree;

class AVL {
    Node root;
    class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
            height = 0;
        }
    }

    public int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    public int getBalanced(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    public Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.right;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
}
public class AVLTree {
}
