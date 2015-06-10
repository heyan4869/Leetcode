/*
 * 1. Start with pointer left = 0 and pointer right = length - 1
 * 2. The max water is limited by the pointer with smaller height
 * 3. When moving a pointer, the width of the area decrease
 * 4. If we move the pointer with higher height, we will never get 
 *    a greater area, the max height will be at most the one of the 
 *    pointer with smaller height
 * 5. So we need to move the pointer with smaller height to have a 
 *    chance to get higher height at the next step.
*/

package array;

public class ContainMostWater {
	public int maxArea(int[] height) {
		int maxWater = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			maxWater = Math.max(maxWater,
					(right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;
	}
}