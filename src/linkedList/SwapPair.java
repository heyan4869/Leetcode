package linkedList;

public class SwapPair {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
        	return null;
        }
        if (head.next == null) {
        	return head;
        }
        ListNode fake = new ListNode(Integer.MAX_VALUE);
        fake.next = head;
        ListNode pre = fake;
        ListNode curr = head;
        
        // this is the most important part
        while (curr != null) {
        	if (curr.next == null) {
        		break;
        	}
        	ListNode temp = curr.next;
        	curr.next = temp.next;
            temp.next = curr;
            pre.next = temp;
            pre = curr;
            curr = curr.next;
        }
        
        return fake.next;
    }
    
    public static void main(String args[]) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	ListNode curr = swapPairs(head);
    	curr.printAll();
    }
}