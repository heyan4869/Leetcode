// link the last element to the head, and then walk (len - n % len) step
// cut at the stop position

package linkedList;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || head.next==null)
			return head;
		ListNode curr = head;
		int count = 1;
		while(curr.next!=null) {
			curr = curr.next;
			count++;
		}
		curr.next = head;
		int step = count - n % count;
		ListNode prev = head;
		while(step>0) {
			prev = head;
			head = head.next;
			step--;
		}
		prev.next = null;
		return head;
	}
}