package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    TreeNode buildTree(int[] in, int[] post, int start, int end, int last) {

        if (start > end)
            return null;

        TreeNode root = new TreeNode(post[last]);
        int index = 0;
        while (in[end - index] != post[last])
            index++;
        root.right = buildTree(in, post, end - index + 1, end, last - 1);
        root.left = buildTree(in, post, start, end - index - 1, (last - index) - 1);

        return root;
    }
}
