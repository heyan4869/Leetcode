// Given a sorted linked list, delete all nodes that have duplicate
// numbers, leaving only distinct numbers from the original list.

package linkedList;

public class RemoveDuplicatesTwo {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode prev = new ListNode(Integer.MIN_VALUE);
        prev.next = head;
        head = prev;
        
        ListNode n1 = head;
        while(n1.next!=null){
            ListNode n2 = n1.next;
            while(n2.next!=null && n2.val==n2.next.val){
                n2=n2.next;
            }
            if(n2!=n1.next){
                n1.next=n2.next;
            }else{
                n1=n1.next;   
            }
        }
        return head.next;		
	}
}