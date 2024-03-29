import java.util.ArrayList;
import java.util.Arrays;

public class ConstructTreeFromPreorderAndInorder {
    public static BTNode<Integer> construct(ArrayList<Integer> inorder, ArrayList<Integer> preorder,
            int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderStart > inorderEnd)
            return null;
        BTNode<Integer> root = new BTNode<Integer>(preorder.get(preorderStart));
        int rootIndexInInorder = inorder.indexOf(preorder.get(preorderStart));
        
        root.left = construct(inorder, preorder, inorderStart, rootIndexInInorder - 1, preorderStart + 1, rootIndexInInorder);
        root.right = construct(inorder, preorder, rootIndexInInorder + 1, inorderEnd, preorderStart + (rootIndexInInorder - inorderStart) + 1, preorderEnd);
        return root;
    }

    public static BTNode<Integer> construct(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        return construct(inorder, preorder, 0, inorder.size() - 1, 0, preorder.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        inorder.addAll(Arrays.asList(new Integer[] { 10, 4, 7, 6, 9, 2, 1, 3, 12, 13, 11 }));
        preorder.addAll(Arrays.asList(new Integer[] { 1, 2, 4, 10, 6, 7, 9, 3, 11, 12, 13 }));
        BTNode<Integer> root = construct(inorder, preorder);
        BinaryTree.printInOrder(root);
        System.out.println();
        BinaryTree.printPreOrder(root);
        System.out.println();
        BinaryTree.printPostOrder(root);
    }
}
