package tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode root) {
        //check the root to avoid infinite loop
        if(root==null)
            return 0;
        
        //get the height of left node and right node
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        //check if it is balanced
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}