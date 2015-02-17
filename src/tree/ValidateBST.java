package tree;

import java.util.Stack;


public class ValidateBST {
	
	// need to use iteration
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
        	return true;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while (!s.isEmpty()) {
        	TreeNode curr = s.pop();
        	if (curr.left != null) {
        		s.add(curr.left);
        		if (checkLeft(curr.left, curr) == false) {
        			return false;
        		}
        	}
        	if (curr.right != null) {
        		s.add(curr.right);
        		if (checkRight(curr.right, curr) == false) {
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public static boolean checkLeft(TreeNode left, TreeNode root) {
    	Stack<TreeNode> l = new Stack<TreeNode>();
    	l.add(left);
    	while (!l.isEmpty()) {
    		TreeNode temp = l.pop();
    		if (temp.val >= root.val)
    			return false;
    		if (temp.left != null) {
    			l.add(temp.left);
    			if (temp.left.val >= root.val)
    				return false;
    		}
    		if (temp.right != null) {
    			l.add(temp.right);
    			if (temp.right.val >= root.val)
    				return false;
    		}
    	}
    	return true;
    }
    
    public static boolean checkRight(TreeNode right, TreeNode root) {
    	Stack<TreeNode> l = new Stack<TreeNode>();
    	l.add(right);
    	while (!l.isEmpty()) {
    		TreeNode temp = l.pop();
    		if (temp.val <= root.val)
    			return false;
    		if (temp.left != null) {
    			l.add(temp.left);
    			if (temp.left.val <= root.val)
    				return false;
    		}
    		if (temp.right != null) {
    			l.add(temp.right);
    			if (temp.right.val <= root.val)
    				return false;
    		}
    	}
    	return true;
    }
    
    // not working
    public static boolean assist(TreeNode root) {
    	if (root == null)
    		return true;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.add(root);
    	while (!s.isEmpty()) {
    		TreeNode temp = s.pop();
    		if (temp.left != null && temp.right != null) {
    			s.add(temp.left);
    			s.add(temp.right);
    			if ((temp.left.val > root.val) || (temp.right.val < root.val))
    				return false;
    		} else if (temp.left != null && temp.right == null) {
    			s.add(temp.left);
    			if (temp.left.val > root.val)
    				return false;
    		} else if (temp.left == null && temp.right != null) {
    			s.add(temp.right);
    			if (temp.right.val < root.val);
    		} else {
    			continue;
    		}
    	}
    	return true;
    }
    
    // recursive not applicable
    public static boolean helper(TreeNode root, TreeNode node) {
    	if (root == null)
    		return true;
    	if (root.left != null && root.right != null) {
    		if (root.left.val >= node.val || root.right.val <= node.val) {
    			return false;
    		} else {
    			return helper(root.left, node) && helper(root.right, node);
    		}
    	} else if (root.left != null && root.right == null) {
    		if (root.left.val >= node.val) {
    			return false;
    		} else {
    			return helper(root.left, node);
    		}
    		
    	} else if (root.left == null && root.right != null) {
    		if (root.right.val <= node.val) {
    			return false;
    		} else {
    			return helper(root.right, node);
    		}
    	} else {
    		return true;
    	}
    	
    }
    
    public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		//root.right = new TreeNode(15);
		//root.right.left = new TreeNode(13);
		//root.right.right = new TreeNode(20);
		
		System.out.println(isValidBST(root));
	
	}
}