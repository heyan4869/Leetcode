// Given a binary tree, flatten it to a linked list in-place.

package tree;

public class FlattenBST {
	public void flatten(TreeNode head) {
		if(head != null && head.left !=null && head.right != null) 
		    builder(head);
	}
	
	public TreeNode builder(TreeNode head) {
		if (head == null) {
			return null;
		} else if (head !=null && head.left == null && head.right == null) {
		    return head;
		} else if (head.left != null && head.right == null) {
			TreeNode l = builder(head.left);
			head.right = l;
			head.left = null;
			return head;
		} else if(head.right != null && head.left == null) {
			TreeNode r = builder(head.right);
			head.right = r;
			return head;
		} else {
			TreeNode l = builder(head.left);
			TreeNode r = builder(head.right);
			head.right = l;
			head.left = null;
			l.right = r;
			l.left = null;
			return head;
		}
		
		
	}
	
	public ListNode helper(TreeNode head) {
		if (head == null) {
			return null;
		}
		ListNode n = new ListNode(head.val);
		n.next = helper(head.left);
		n.next.next = helper(head.right);
		return n;
	}
	
	private TreeNode flattenHelper(TreeNode root){
        if (root == null) 
            return null;
            
        TreeNode lastNode = root;
        TreeNode lastLeftNode = this.flattenHelper(root.left);
        TreeNode lastRightNode = this.flattenHelper(root.right);

        if (lastLeftNode != null) {
            lastNode = lastLeftNode;
            lastLeftNode.right = root.right;        
            root.right = root.left;
            root.left = null;
        }

        if (lastRightNode != null){
            lastNode = lastRightNode;
        }
        return lastNode;
    }
}