package tree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        //check the root
        if(root==null)
            return 0;
        
        //get the height of left and right node
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        //compare and return the larger one
        return Math.max(leftHeight, rightHeight) + 1;
    }
}