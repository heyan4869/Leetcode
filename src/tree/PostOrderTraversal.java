package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> rs = new ArrayList<Integer>();
		if (root == null) {
			return rs;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		st = assist(st, root);
		while (!st.isEmpty()) {
			rs.add(st.pop().val);
		}
		return rs;
	}

	private static Stack<TreeNode> assist(Stack<TreeNode> st, TreeNode root) {
		if (root == null) {
			return null;
		} else {
			st.push(root);
			if (root.right != null) {
				assist(st, root.right);
			}
			if (root.left != null) {
				assist(st, root.left);
			}
			return st;
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		List<Integer> list = postorderTraversal(root);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}