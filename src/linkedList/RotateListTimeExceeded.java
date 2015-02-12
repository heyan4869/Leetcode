package linkedList;

public class RotateListTimeExceeded {
	
	// this solution is time exceeded
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
            return head;
        ListNode q = head;
        ListNode prev = head;
        for(int count=0; count<n; count++) {
        	while(q.next!=null) {
        		prev = q;
        		q = q.next;
        	}
        	prev.next = null;
        	q.next = head;
        	
        }
        return q;
    }
}