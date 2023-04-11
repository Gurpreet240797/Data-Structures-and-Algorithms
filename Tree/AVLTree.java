package Tree;

class AVL {
    Node root;

    class Node {
        int data;
        int height;
        Node left, right;

        Node (int data) {
            this.data = data;
            height = 0;
            left = right = null;
        }
    }

    public int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.right), height(node.left));
    }

    public int getBalanced(Node node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node leftRotate(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node reBalance(Node z) {
        updateHeight(z);
        int balance = getBalanced(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = leftRotate(z);
            } else {
                z.right = rightRotate(z.right);
                z = leftRotate(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rightRotate(z);
            } else {
                z.left = rightRotate(z.left);
                z = rightRotate(z);
            }
        }
        return z;
    }

    public Node insert(Node node, int data) {
        if (node == null) return new Node(data);
        else if (node.data > data) node.left = insert(node.left, data);
        else if (node.data < data) node.right = insert(node.right, data);
        else new RuntimeException("Duplicate Key");

        return reBalance(node);
    }

}
public class AVLTree {
}
