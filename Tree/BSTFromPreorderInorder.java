package Tree;

class MyHashMap {
    int[] arr;
    int size;
    int noOfElements;

    MyHashMap(int size) {
        this.size = size;
        arr = new int[size];
        noOfElements = 0;
    }

    private int findHashIndex(int key) {
        int hashIndex = key % size;
        int increments = 0;
        while (arr[hashIndex] != 0) {
            int hashIndexChange = 13 - (key % 3);
            increments += 1;
            int hashIndexNew = ((hashIndexChange * increments)+ hashIndex) % size;
            hashIndex = hashIndexNew;
        }

        return hashIndex;
    }

    public void put(int value) {

    }
}

class MyBST {
    class TreeNode {
        private int value;
        private TreeNode left, right;

        TreeNode() {this(0);}

        TreeNode (int value) {
            this.value = value;
            left = right = null;
        }
    }

    TreeNode root;

    public void addNode(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode itr = root;
        TreeNode parent;

        while (true) {
            if (val < itr.value) {
                parent = itr;
                itr = itr.left;
                if (itr == null) {
                    parent.left = new TreeNode(val);
                    return;
                }
            } else {
                parent = itr;
                itr = itr.right;
                if (itr == null) {
                    parent.right = new TreeNode(val);
                    return;
                }
            }
        }
    }

    public void buildTree(int[] preOrder, int[] inorder) {

    }
}

public class BSTFromPreorderInorder {
    public static void main(String[] args) {
        MyBST bst = new MyBST();
        bst.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }
}
