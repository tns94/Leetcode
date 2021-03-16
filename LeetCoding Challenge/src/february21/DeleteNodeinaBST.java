package february21;

import utils.TreeNode;

/*
https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeinaBST {
    TreeNode parent;
    TreeNode searchNode;
    boolean leftNode;
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy= new TreeNode(Integer.MIN_VALUE,root,null);
        parent=dummy;
        leftNode=true;
        if(!search(root,key,true,dummy)) return root;
        delete(searchNode);
        return dummy.left;
    }
    boolean search(TreeNode node,int key,boolean left,TreeNode par)
    {
        if(node == null)
            return false;
        if(node.val==key){
            searchNode=node;
            leftNode=left;
            parent=par;
            return true;
        }
        if(search(node.left,key,true,node)) return true;
        if(search(node.right,key,false,node)) return true;
        return false;
    }
    void delete(TreeNode node)
    {
        if(node.left == null && node.right == null)
        {
            if(leftNode)
                parent.left = null;
            else
                parent.right = null;
            return;
        }
        if(node.left == null)
        {
            if(leftNode)
                parent.left = node.right;
            else
                parent.right = node.right;
            return;
        }

        if(node.right == null)
        {
            if(leftNode)
                parent.left = node.left;
            else
                parent.right = node.left;
            return;
        }

        TreeNode replacement = searchLeftMost(searchNode.right,searchNode);

        if(leftNode)
            parent.left = replacement;
        else
            parent.right = replacement;
        replacement.left=searchNode.left;
        if(replacement != searchNode.right)
        replacement.right=searchNode.right;
    }

    TreeNode searchLeftMost(TreeNode node,TreeNode parent)
    {
        if(node.left == null)
        {
            if(parent!=searchNode)
                parent.left=node.right;
            return node;
        }
        return searchLeftMost(node.left,node);
    }
}
