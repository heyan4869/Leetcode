package tree;

public class BinaryTreeFromInorderAndPostorder {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		assist(root, inorder, postorder, 0, postorder.length - 1);
		return root;
	}

	private static void assist(TreeNode root, int[] inorder, int[] postorder,
			int start, int end) {
		if (start >= end) {
			return;
		}
		int curr = root.val;
		int inindex = -1;
		for (int i = start; i <= end; i++) {
			if (curr == inorder[i]) {
				inindex = i;
				break;
			}
		}
		int before = inindex - start;
		int after = end - inindex;

		int postindex = -1;
		for (int j = 0; j <= postorder.length - 1; j++) {
			if (curr == postorder[j]) {
				postindex = j;
				break;
			}
		}

		if (start + before - 1 >= postorder.length) {
			return;
		} else if (before != 0) {
			root.left = new TreeNode(postorder[postindex - after - 1]);
			assist(root.left, inorder, postorder, start, start + before - 1);
		}
		if (start + before + after - 1 >= postorder.length) {
			return;
		} else if (after != 0) {
			root.right = new TreeNode(postorder[postindex - 1]);
			assist(root.right, inorder, postorder, end - after + 1, end);
		}
	}

	public static void main(String args[]) {
		int[] inorder = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] postorder = { 1, 3, 5, 4, 2, 8, 9, 7, 6 };
		TreeNode root = buildTree(inorder, postorder);
		System.out.println(root.left.left.val);
	}
}