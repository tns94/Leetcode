package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3485/
 */
public class InsertIntoBinarySearchTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode= new TreeNode(val);
        TreeNode current= root;
        TreeNode previous= null;
        
        while (current != null)
        {
            previous =current;
            if( current.val < val)
                current = current.right;
            else
                current = current.left;
        }

        if(previous== null)
            root =  newNode;
        else if(previous.val < val)
            previous.right=newNode;
        else
            previous.left=newNode;


        return root;
    }

}
