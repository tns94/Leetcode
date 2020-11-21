package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3489/
 */
public class SerializeandDeserializeBST {
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder encodedString=new StringBuilder();
        preOrder(root,encodedString);
        return encodedString.toString();
    }
    void preOrder(TreeNode node, StringBuilder encodedString)
    {
        if(node == null)
            return;
        encodedString.append((char)node.val);
        preOrder(node.left,encodedString);
        preOrder(node.right,encodedString);
    }

    // Decodes your encoded data to tree.
    int index=0;
    public TreeNode deserialize(String data) {
        index=0;
        return preOrderSolver(data,0,10001);
    }
    TreeNode preOrderSolver(String nums,int l,int h)
    {
        if(index >= nums.length())
            return null;
        int num=(int) nums.charAt(index);
        if(num < l || num > h) return null;
        index++;
        
        TreeNode node=new TreeNode(num);
        node.left=preOrderSolver(nums,l,num);
        node.right=preOrderSolver(nums,num,h);
        return node;
    }


}
