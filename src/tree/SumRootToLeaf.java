package tree;

import java.util.Stack;

public class SumRootToLeaf {
    public static int sumNumbers(TreeNode root) {
        if (root == null)
        	return 0;
        Stack<String> path = new Stack<String>();
        String curr = "";
        path = helper(root, path, curr);
        int result = 0;
        while (!path.isEmpty()) {
        	result = result + Integer.parseInt(path.pop());
        }
        return result;
    }

	public static Stack<String> helper(TreeNode node, Stack<String> path, String curr) {
		if (node.left == null && node.right == null) {
			curr = curr + node.val;
			path.push(curr);
			return path;
		}
		curr = curr + node.val;
		//System.out.println(curr);
		if (node.left != null) {
			helper(node.left, path, curr);
		}
		if (node.right != null) {
			helper(node.right, path, curr);
		}
		return path;
		
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
}