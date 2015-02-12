// this solution is time exceeded : (

package tree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LinkedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
    	ListNode backup = head;
        int len = getLen(backup);
    	TreeNode root = builder(head, 0, len - 1);

    	return root;
    }
    
    public int getLen(ListNode backup) {
    	int len = 0;
		while (backup != null) {
			len++;
			backup = backup.next;
		}
		return len;
	}
    
    public int getNode(ListNode head, int num) {
    	if (num == 0)
    		return head.val;
    	ListNode temp = head;
    	while (num > 0) {
    		// this could not iterate, head is always head
    		// temp = head.next;
    		temp = temp.next;
    		num--;
    	}
    	return temp.val;
    }

	public TreeNode builder(ListNode head, int low, int high) {
    	if (low > high)
    		return null;
    	int mid = (low + high) / 2;
    	TreeNode curr = new TreeNode(getNode(head, mid));
    	curr.left = builder(head, low, mid - 1);
    	curr.right = builder(head, mid + 1, high);
    	
    	return curr;
    }
}