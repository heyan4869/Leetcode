package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		addRightMost(0, root, temp);
		List<Integer> result = new ArrayList<Integer>(temp.values());
		return result;
	}

	public static void addRightMost(int level, TreeNode root,
			HashMap<Integer, Integer> temp) {
		if (root == null) {
			return;
		}
		if (!temp.containsKey(level)) {
			temp.put(level, root.val);
		}
		if (root.right != null) {
			addRightMost(level + 1, root.right, temp);
		}
		if (root.left != null) {
			addRightMost(level + 1, root.left, temp);
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		List<Integer> rv = rightSideView(root);
		for (int a : rv) {
			System.out.println(a);
		}
	}
}