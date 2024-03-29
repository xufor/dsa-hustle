import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

class Tree<T> {
    public TreeNode<T> root;
    public static Scanner scnr = new Scanner(System.in);

    public static Tree<Integer> construct() {
        Tree<Integer> tree = new Tree<Integer>();
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        tree.root = new TreeNode<Integer>(scnr.nextInt());
        pendingNodes.add(tree.root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> nodeToBeProcessed = pendingNodes.remove();
            int childCount = scnr.nextInt();
            for (int i = 0; i < childCount; i++) {
                TreeNode<Integer> node = new TreeNode<Integer>(scnr.nextInt());
                nodeToBeProcessed.children.add(node);
                pendingNodes.add(node);
            }
        }
        return tree;
    }

    public void printLevelOrder() {
        if (root == null)
            return;
        Queue<TreeNode<T>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<T> nodeToBeProcessed = pendingNodes.remove();
            System.out.print(nodeToBeProcessed.data + " ");
            for (TreeNode<T> childNode : nodeToBeProcessed.children) {
                pendingNodes.add(childNode);
            }
        }
        System.out.println();
    }
}

public class CreateAndPrintTree {
    public static void main(String[] args) {
        // 1 2 2 3 3 4 5 6 1 7 0 0 0 0 0
        Tree<Integer> tree = Tree.construct();
        tree.printLevelOrder();
    }
}