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

package linkedList;

public class RemoveNthToLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p = head;
        ListNode q = head;
        ListNode prev = head;
        if(head.next==null && n==1)
            return null;
        int count = 0;
        while(count<n-1) {
        	if(q==null)
        		return null;
        	q = q.next;
        	count++;
        }
        while(p.next!=null && q.next!=null) {
        	prev = p;
        	p = p.next;
        	q = q.next;
        	
        }
        // if the head node need to be removed, then we need to just skip the head node
        if(p==head)
            return head.next;
        prev.next = p.next;
        return head;
    }
}