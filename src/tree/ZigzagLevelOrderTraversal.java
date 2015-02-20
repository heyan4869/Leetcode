/*
 * Given a binary tree, return the zigzag level order traversal of its 
 * nodes' values. (ie, from left to right, then right to left for the 
 * next level and alternate between).
 */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLevelOrderTraversal {
	static class LevelNode {
		TreeNode node;
		int level;
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// initial the list for storing the list
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();

		if (root == null)
			return result;

		// create a queue to store
		Queue<LevelNode> q = new LinkedList<LevelNode>();

		// initial the root
		LevelNode n = new LevelNode();
		n.node = root;
		n.level = 1;

		// add the root in the queue
		q.add(n);

		// level by level
		while (!q.isEmpty()) {
			LevelNode temp = q.peek();
			int level = temp.level;

			if (level % 2 == 1) {
				// initial list and add the curr value
				row = new ArrayList<Integer>();

				while (q.peek().level == level) {
					LevelNode curr = q.remove();

					row.add(curr.node.val);

					if (curr.node.left != null) {
						LevelNode left = new LevelNode();
						left.node = curr.node.left;
						left.level = curr.level + 1;
						q.add(left);

					}
					if (curr.node.right != null) {
						LevelNode right = new LevelNode();
						right.node = curr.node.right;
						right.level = curr.level + 1;
						q.add(right);
					}

					// if there is nothing left in the queue, break the loop
					if (q.peek() == null)
						break;
				}
				result.add(row);

			} else {
				row = new ArrayList<Integer>();
				Stack<Integer> backup = new Stack<Integer>();
				while (q.peek().level == level) {
					LevelNode curr = q.remove();
					backup.push(curr.node.val);

					if (curr.node.left != null) {
						LevelNode left = new LevelNode();
						left.node = curr.node.left;
						left.level = curr.level + 1;
						q.add(left);

					}
					if (curr.node.right != null) {
						LevelNode right = new LevelNode();
						right.node = curr.node.right;
						right.level = curr.level + 1;
						q.add(right);
					}

					// if there is nothing left in the queue, break the loop
					if (q.peek() == null)
						break;

				}
				while (!backup.isEmpty()) {
					row.add(backup.pop());
				}

				result.add(row);
			}

		}

		return result;

	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = zigzagLevelOrder(root);
		// System.out.println(root.right.val);
		System.out.println(result);

	}
}