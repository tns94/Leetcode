package october;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3514/
 */
public class RecoverBinarySearchTree {

    TreeNode wrongOne,wrongTwo, prevNode;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp=wrongOne.val;
        wrongOne.val=wrongTwo.val;
        wrongTwo.val=temp;
    }
    
    void inOrder(TreeNode node)
    {
        if(node==null)
            return;
        inOrder(node.left);
        if(prevNode !=null)
        {
            if(prevNode.val > node.val)
            {
                if(wrongOne==null)
                {
                    wrongOne=prevNode;
                }
                wrongTwo=node;
            }
        }
        prevNode=node;
        inOrder(node.right);
    }


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

}
