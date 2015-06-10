// review this question

package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBSTII {
	public static List<TreeNode> generateTrees(int n) {
		return assist(1, n);
	}

	public static List<TreeNode> assist(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int rootVal = start; rootVal <= end; rootVal++) {
			List<TreeNode> leftSubTrees = assist(start, rootVal - 1);
			List<TreeNode> rightSubTrees = assist(rootVal + 1, end);
			for (TreeNode leftSub : leftSubTrees) {
				for (TreeNode rightSub : rightSubTrees) {
					TreeNode root = new TreeNode(rootVal);
					root.left = leftSub;
					root.right = rightSub;
					res.add(root);
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		System.out.println(0);
	}
}