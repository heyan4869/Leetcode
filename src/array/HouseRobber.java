package array;

public class HouseRobber {
	public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] total = new int[nums.length + 1];
        total[0] = 0;
        total[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i - 1]);
        }
        return total[nums.length];
    }
	
	// this solution is not dp! it contains a lot of duplicate computation
    public static int rob2(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        if (nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        return assist(nums, 0, 0, false);
    }

	private static int assist(int[] nums, int total, int curr, boolean pre) {
		if (curr == nums.length - 1) {
			return total;
		}
		if (pre == false) {
			return Math.max(assist(nums, total + nums[curr], curr + 1, true), assist(nums, total, curr + 1, false));
		} else {
			return assist(nums, total, curr + 1, false);
		}
		
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 3};
		System.out.println(rob(nums));
	}
}