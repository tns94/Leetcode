package march21;

import utils.TreeNode;

/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
    TreeNode constructTree(int[] preOrder, int i, int j) {
        if (i > j)
            return null;

        TreeNode node = new TreeNode(preOrder[i]);
        if (i == j)
            return node;
        int k = i + 1;
        for (; k <= j; k++) {
            if (preOrder[k] > preOrder[i])
                break;
        }
        node.left = constructTree(preOrder, i + 1, k - 1);
        node.right = constructTree(preOrder, k, j);
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, 0, preorder.length - 1);
    }
}
