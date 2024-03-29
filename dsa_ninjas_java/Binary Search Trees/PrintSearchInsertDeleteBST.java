class BTNode<T> {
    T data;
    BTNode<T> left;
    BTNode<T> right;

    BTNode(T data) {
        this.data = data;
    }
}

class BinarySearchTree {
    public BTNode<Integer> root;

    private BTNode<Integer> search(BTNode<Integer> root, int data) {
        if (root == null)
            return null;
        else if (data > root.data)
            return search(root.right, data);
        else if (data < root.data)
            return search(root.left, data);
        else
            return root;
    }

    public boolean search(int data) {
        return search(this.root, data) != null;
    }

    private BTNode<Integer> insert(BTNode<Integer> root, int data) {
        if (root == null)
            return new BTNode<Integer>(data);
        else if (data > root.data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);
        return root;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private BTNode<Integer> delete(BTNode<Integer> root, int data) {
        if (root == null)
            return null;
        else if (data > root.data) {
            root.right = delete(root.right, data);
            return root;
        }
        else if (data < root.data) {
            root.left = delete(root.left, data);
            return root;
        }
        else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else {
                BTNode<Integer> inorderSuccessor = root.right;
                while(inorderSuccessor.left != null)
                    inorderSuccessor = inorderSuccessor.left;
                root.data = inorderSuccessor.data;
                root.right = delete(root.right, inorderSuccessor.data);
                return root;
            }
        }
    }

    public void delete(int data) {
        this.root = delete(this.root, data);
    }

    private void printInOrder(BTNode<Integer> root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    private void printPostOrder(BTNode<Integer> root) {
        if(root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void printPreOrder(BTNode<Integer> root) {
        if(root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    public void printPostOrder() {
        printPostOrder(this.root);

    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }
}

public class PrintSearchInsertDeleteBST {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int data : new Integer[] { 9, 4, 5, 2, 3, 7, 8, 1, 6, 10 }) {
            binarySearchTree.insert(data);
            binarySearchTree.printInOrder();
            System.out.println();
        }
        //              9
        //             / \
        //            4   10
        //           / \
        //          2   5
        //         / \   \
        //        1   3   7
        //               / \
        //              6   8
        System.out.println(binarySearchTree.search(0));
        System.out.println(binarySearchTree.search(3));
        for (int data : new Integer[] { 9, 4, 5, 2, 3 }) {
            binarySearchTree.delete(data);
            binarySearchTree.printInOrder();
            System.out.println();
        }
    }
}