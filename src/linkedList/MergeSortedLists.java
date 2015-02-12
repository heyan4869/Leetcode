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
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
        	return null;
        else if(l1==null && l2!=null)
        	return l2;
        else if(l1!=null && l2==null)
        	return l1;
        
        ListNode temp = new ListNode(0);
        ListNode prev = temp;
        
        while(l1!=null && l2!=null) {
            if(l1.val>l2.val) {
                prev.next=l2;
                l2=l2.next;
            }else {
                prev.next=l1;
                l1=l1.next;
            }
            prev=prev.next;
        }
        if (l1!=null) 
        	prev.next=l1;
        else if (l2!=null) 
        	prev.next=l2;
        return temp.next;
    }
}