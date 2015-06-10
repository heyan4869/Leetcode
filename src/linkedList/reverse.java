package linkedList;

public class reverse {
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode temp = new ListNode(head.val);
		return assist(temp, head);
	}

	public static ListNode assist(ListNode temp, ListNode curr) {
		if (curr.next == null) {
			return temp;
		}
		ListNode backup = new ListNode(curr.next.val);
		backup.next = temp;
		curr = curr.next;
		return assist(backup, curr);
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		// head.next.next = new ListNode(3);
		ListNode curr = reverseList(head);
		System.out.println(curr.val);
	}
}