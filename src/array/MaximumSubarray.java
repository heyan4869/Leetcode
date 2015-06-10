package array;

public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			result = Math.max(result, sum);
		}

		return result;
	}

	public static void main(String args[]) {
		int[] anArray = new int[7];
		anArray[0] = -3;
		anArray[1] = -4;
		anArray[2] = 5;
		anArray[3] = 6;
		anArray[4] = 7;
		anArray[5] = 1;
		anArray[6] = 2;
		System.out.println(maxSubArray(anArray));
	}
}