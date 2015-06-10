// PriorityQueue always keep the smallest element at the head position

package array;

import java.util.PriorityQueue;

public class KthLargestElement {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			if (queue.size() < k)
				queue.add(nums[i]);
			else {
				if (nums[i] > queue.peek()) {
					queue.remove();
					queue.add(nums[i]);
				}
			}
		}
		return queue.remove();
	}
	
	public static void main(String args[]) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargest(nums, 2));
	}
}