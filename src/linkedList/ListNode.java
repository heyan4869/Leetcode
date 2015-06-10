package linkedList;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     public void printAll() {
    	 ListNode backup = this;
    	 while (backup != null) {
    		 System.out.println(backup.val);
    		 backup = backup.next;
    	 }
     }
}
