/*
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at 
 * the same level, and every parent has two children).
 * 
 * idea: this problem is similar to the level order traversal
 */

package tree;

public class PopulatingNextRightPointers {
	// only use constant extra space
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode leftside = root;
		// root.next = null;
		while (leftside != null && leftside.left != null) {
			TreeLinkNode traversal = leftside;
			while (traversal != null) {
				// if parent has left child, point to its right child
				if (traversal.left != null) {
					traversal.left.next = traversal.right;
				}

				// if parent has next node, point its right child to
				// its next node's left child
				if (traversal.right != null && traversal.next != null) {
					traversal.right.next = traversal.next.left;
				}

				// make sure to go throught the whole level
				traversal = traversal.next;
			}
			// always take the most left path
			leftside = leftside.left;
		}
	}

	public static void main(String args[]) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		connect(root);
		System.out.println(root.right.left.next.val); // should be 3
	}
}