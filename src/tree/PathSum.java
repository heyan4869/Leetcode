/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package tree;


public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        
        sum = sum - root.val;
        
        if(root.left == null && root.right == null)
        	return sum == 0;
        else
        	return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}