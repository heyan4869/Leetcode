package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> trav = new ArrayList<Integer> ();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.add(curr);
				curr = curr.left;
			}
			
			curr = s.pop();
			trav.add(curr.val);
			
			//always check if curr has a right child
			curr = curr.right;
		}
		
		return trav;
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(10);
		//root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		System.out.println(inorderTraversal(root));
	}
}
