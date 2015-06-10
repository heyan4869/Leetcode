package linkedList;

public class RemoveElements {
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		fakeHead.next = head;
		ListNode curr = fakeHead;
		while (curr.next != null) {
			if (curr.next.val == val) {
				ListNode temp = curr.next;
				while (temp.val == val && temp.next != null) {
					temp = temp.next;
				}
				if (temp.val != val) {
					curr.next = temp;
					curr = curr.next;
				} else {
					curr.next = null;
					// break;
				}
			} else {
				curr = curr.next;
			}
		}
		return fakeHead.next;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(3);
		ListNode two = new ListNode(4);
		ListNode thr = new ListNode(2);
		ListNode fou = new ListNode(4);
		head.next = two;
		head.next.next = thr;
		head.next.next.next = fou;
		ListNode result = removeElements(head, 3);
		while (result != null) {
			System.out.print("  " + result.val + "  ");
			result = result.next;
		}
	}
}