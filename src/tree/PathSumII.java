package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		int cursum = 0;
		assist(root, sum, cursum, temp, res);
		return res;
	}

	private static void assist(TreeNode root, int sum, int cursum,
			List<Integer> temp, List<List<Integer>> res) {
		cursum += root.val;
		temp.add(root.val);
		// check if current sum is equal to the target sum
		if (cursum == sum && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(temp));
			temp.remove(temp.size() - 1);
			return;
		}
		if (root.left != null) {
			assist(root.left, sum, cursum, temp, res);

		}
		if (root.right != null) {
			assist(root.right, sum, cursum, temp, res);
		}
		temp.remove(temp.size() - 1);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		 root.left.left = new TreeNode(11);
		 root.right.left = new TreeNode(13);
		 root.right.right = new TreeNode(4);
		 root.left.left.left = new TreeNode(7);
		 root.left.left.right = new TreeNode(2);
		 root.right.right.left = new TreeNode(5);
		 root.right.right.right = new TreeNode(1);
		List<List<Integer>> res = pathSum(root, 22);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println("");
		}
	}
}