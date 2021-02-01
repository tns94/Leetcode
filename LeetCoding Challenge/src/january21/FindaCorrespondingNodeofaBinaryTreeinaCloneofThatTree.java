package january21;

import utils.TreeNode;

/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3590/
 */
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
    TreeNode ret;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original,cloned,target);
        return ret;
    }
    boolean dfs( TreeNode original,  TreeNode cloned, TreeNode target)
    {
        if(original==null)
            return false;
        if(original==target)
        {
            ret=cloned;
            return true;
        }
        if(dfs(original.left,cloned.left,target) || dfs(original.right,cloned.right,target))
            return true;
        return false;
    }
}
