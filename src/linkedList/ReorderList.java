package linkedList;

import java.util.Stack;

public class ReorderList {
	public static void reorderList(ListNode head) {
		int len = getLen(head);
		if (len == 0 || len == 1 || len == 2)
			return;
		int count = (len - 1) / 2;
		ListNode preCut = head;
		ListNode postCut = head.next;
		Stack<ListNode> pool = new Stack<ListNode>();
		ListNode curr = head;
		pool = getLast(curr);
		for (int i = 1; i <= count; i++) {
			ListNode secLast = pool.pop();
			ListNode last = secLast.next;
			preCut.next = last;
			last.next = postCut;
			secLast.next = null;
			preCut = preCut.next.next;
			postCut = preCut.next;
		}
	}

	public static Stack<ListNode> getLast(ListNode node) {
		Stack<ListNode> s = new Stack<ListNode>();
		while (node.next != null) {
			s.add(node);
			node = node.next;
		}
		return s;
	}

	public static int getLen(ListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		reorderList(head);
		while (head != null) {
			System.out.print("-" + head.val + "-");
			head = head.next;
		}
	}
}