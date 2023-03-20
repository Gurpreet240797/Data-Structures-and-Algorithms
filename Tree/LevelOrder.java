package Tree;

class Linked {
    Node head;
    Node tail;
    int size = 0;
    class Node {
        BinaryTree.Node value;
        Node next;

        Node (BinaryTree.Node value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addToEnd(BinaryTree.Node val) {
        if (head == null) {
            head =  new Node(val, null);
            size += 1;
            tail = head;
            return;
        }

        Node itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }

        itr.next = new Node(val, null);
        tail = itr.next;
        size += 1;
    }

    public void removeFromStart() {
        if (head == null) {
            System.out.println("NO REMOVE");
            return;
        }

        head = head.next;
        size -= 1;
    }
}
class BinaryTree {
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

    public void levelOrder() throws Exception {
        if (root == null) throw new Exception("NO TREE");

        Linked ll = new Linked();
        Node itr = root;
        ll.addToEnd(itr);

        while (ll.size != 0) {
            level += 1;
            itr = ll.head.value;
            System.out.print(itr.value + " ");
            if (itr.left != null) {
                ll.addToEnd(itr.left);
            }

            if (itr.right != null) {
                ll.addToEnd(itr.right);
            }

            ll.removeFromStart();
        }
    }
}

public class LevelOrder {
    public static void main (String args[]) throws Exception {
        BinaryTree bst = new BinaryTree();
        bst.addNode(4);
        bst.addNode(1);
        bst.addNode(2);
        bst.addNode(3);
        bst.addNode(5);

        bst.levelOrder();
        System.out.println();
        System.out.println(bst.level-1);
        System.out.println(bst.size);
    }
}
