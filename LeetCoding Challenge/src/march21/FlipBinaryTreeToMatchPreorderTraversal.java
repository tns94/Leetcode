package march21;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3689/
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> answer = new ArrayList<>();

        if (dfs(root, voyage, answer)) {
            return answer;
        } else {
            return Arrays.asList(new Integer[]{-1});
        }
    }

    int i = 0;

    boolean dfs(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null)
            return true;
        if (root.val != voyage[i])
            return false;
        i++;
        if (root.left != null && root.left.val != voyage[i]) {
            list.add(root.val);
            return dfs(root.right, voyage, list) && dfs(root.left, voyage, list);
        } else
            return dfs(root.left, voyage, list) && dfs(root.right, voyage, list);
    }
}
