/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

package tree;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> s;
	TreeNode curr = null;
	
	public BSTIterator(TreeNode root) {
        curr = root;
        s = new Stack<TreeNode>();
        if (root != null) {
        	while (curr != null) {
        		s.push(curr);
        		curr = curr.left;
        	}
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = s.pop();
        TreeNode temp = node.right;
        if(temp!=null){
            while(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
        }
        return node.val;
    }
}