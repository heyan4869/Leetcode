package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
	public static List<Integer> preorder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		
		return result;
	}
	
	public static List<Integer> helper(TreeNode root, List<Integer> result) {
		if (root == null)
			return null;
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
		return result;
	}
	
	
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Integer> result = preorder(root);
		//System.out.println(root.right.val);
		System.out.println(result);
	
	}
}