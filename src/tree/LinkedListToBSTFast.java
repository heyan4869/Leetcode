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
public class LinkedListToBSTFast {
	private ListNode node;
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode backup = head;
        node = head;
        int size = getLen(backup);

    	return helper(0, size - 1);
    }
	
	public TreeNode helper(int start, int end) {
		if(start > end)
			return null;
		
		int mid = start + (end - start) / 2;
		TreeNode left = helper(start, mid - 1);
		
		// why is node.val here? node is head at first
		TreeNode treeNode = new TreeNode(node.val);
		treeNode.left = left;
		
		node = node.next;
		
		TreeNode right = helper(mid + 1, end);
		treeNode.right = right;
		
		return treeNode;
		
	}

	public int getLen(ListNode backup) {
    	int len = 0;
		while (backup != null) {
			len++;
			backup = backup.next;
		}
		return len;
	}
}