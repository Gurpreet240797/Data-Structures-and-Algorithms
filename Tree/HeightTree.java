package Tree;

class Binary {
    Node root;
    int size = 0;
    int level = 0;
    class Node {
        private int value;
        private Node left, right;
        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void addNode(int val) {
        if (root == null) {
            root = new Node(val);
            size += 1;
            return;
        }

        Node itr = root;
        Node parent;

        while (true) {
            if (val < itr.value) {
                parent = itr;
                itr = itr.left;
                if (itr == null) {
                    parent.left = new Node(val);
                    size += 1;
                    return;
                }
            } else {
                parent = itr;
                itr = itr.right;
                if (itr == null) {
                    parent.right = new Node(val);
                    size += 1;
                    return;
                }
            }
        }
    }

    public int height(Node itr) {
        if (itr == null) {
            return 0;
        }
        int left = height(itr.left);
        int right = height(itr.right);

        if (left > right) {
            return (left + 1);
        } else {
            return (right +1);
        }
    }
}

public class HeightTree {
    public static void main (String args[]) throws Exception {
        Binary bst = new Binary();
        bst.addNode(4);
        bst.addNode(3);
        bst.addNode(5);
        bst.addNode(1);
        int h = bst.height(bst.root) -1;
        System.out.println("Height: " + h);
        System.out.println("Depth: " + bst.height(bst.root));
    }
}
