package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import tree.LevelOrderTraversal.LevelNode;

public class LevelOrderTraversal {
	static class LevelNode {
		TreeNode node;
		int level;
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		// initial the list for storing the list
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> row = new ArrayList<Integer>();
				
		if (root==null)
			return result;
		
		// create a queue to store
		Queue<LevelNode> q = new LinkedList<LevelNode>();
		
		// initial the root 
		LevelNode n = new LevelNode();
		n.node = root;
		n.level = 1;
		
		// add the root in the queue
		q.add(n);
		
		Stack<List<Integer>> s = new Stack<List<Integer>>();
		
		
		// level by level
		while (!q.isEmpty()) {
			LevelNode temp = q.peek();
			int level = temp.level;
			
			// initial list and add the curr value
			row = new ArrayList<Integer>();
			
			while (q.peek().level == level) {
				LevelNode curr = q.remove();
				
				row.add(curr.node.val);
				
				if (curr.node.left != null) {
					LevelNode left = new LevelNode();
					left.node = curr.node.left;
					left.level = curr.level+1;
					q.add(left);
					
				}
				if (curr.node.right != null) {
					LevelNode right = new LevelNode();
					right.node = curr.node.right;
					right.level = curr.level+1;
					q.add(right);
				}
				
				// if there is nothing left in the queue, break the loop
				if (q.peek()==null)
					break;
			}
			
			s.push(row);
			
		}
		
		while (!s.isEmpty()) {
			result.add(s.pop());
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = levelOrder(root);
		//System.out.println(root.right.val);
		System.out.println(result);
	
	}
		
}