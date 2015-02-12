package linkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
    	//check head and the next node
        if(head == null || head.next == null)
    		return head;
    		
    	//remove the duplicates
        ListNode node = head;
        while(node != null) {
            ListNode temp = node.next;
            while(temp != null && node.val == temp.val) {
                temp = temp.next;
            }
            node.next = temp;
            //change node to the next different one and iterate again
            node = node.next;
        }
        return head;
    }
}