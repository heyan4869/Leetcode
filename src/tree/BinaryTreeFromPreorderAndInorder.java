package tree;

public class BinaryTreeFromPreorderAndInorder {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		assist(root, preorder, inorder, 0, inorder.length - 1);
		return root;
	}

	public static void assist(TreeNode root, int[] preorder, int[] inorder,
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

		int preindex = -1;
		for (int j = 0; j <= inorder.length - 1; j++) {
			if (curr == preorder[j]) {
				preindex = j;
				break;
			}
		}
		
		// make sure before and after are not 0
		if (preindex + 1 >= preorder.length) {
			return;
		} else if (before != 0) {
			root.left = new TreeNode(preorder[preindex + 1]);
			assist(root.left, preorder, inorder, start, start + before - 1);
		}
		
		if (preindex + before + 1 >= preorder.length) {
			return;
		} else if (after != 0) {
			root.right = new TreeNode(preorder[preindex + before + 1]);
			assist(root.right, preorder, inorder, end - after + 1, end);
		}
	}

	public static void main(String args[]) {
		int[] preorder = { 1, 2 };
		int[] inorder = { 2, 1 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root.left.val);
	}
}