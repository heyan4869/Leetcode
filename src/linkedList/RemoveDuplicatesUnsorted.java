package linkedList;

import java.util.HashSet;
import java.util.Hashtable;

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

public class RemoveDuplicatesUnsorted {
	// Use Hashtable
    public ListNode removeDuplicates(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	
    	ListNode node = null;
    	Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean>();
    	while(head!=null) {
    		if(ht.containsKey(head.val))
    			node.next = head.next;
    		else {
    			ht.put(head.val, true);
    			node = head;
    		}
    		head = head.next;
    	}
    	return node;
    }
    
    // Use HashSet
    public ListNode remove(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	
    	ListNode node = null;
    	HashSet<Integer> hs = new HashSet<Integer>();
    	while(head!=null) {
    		if(hs.contains(head.val))
    			node.next = head.next;
    		else {
    			hs.add(head.val);
    			node = head;
    		}
    		head = head.next;	
    	}
    	
    	return node;
    }
    
    // Without buffer
    public ListNode removeWithoutBuffer(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	
    	ListNode prev = head;
    	ListNode curr = prev.next;
    	while(curr!=null) {
    		ListNode traverse = head;
    		while(traverse!=curr) {
    			if(traverse.val==curr.val) {
    				prev.next = curr.next;
    				curr = curr.next;
    				break;
    			}
    			traverse = traverse.next;
    		}
    		if(traverse==curr) {
    			prev = curr;
    			curr = curr.next;
    		}
    	}
    	
    	return prev;
    }
}