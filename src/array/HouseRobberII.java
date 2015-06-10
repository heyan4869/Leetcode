package array;

public class HouseRobberII {
	public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int use, unuse;
        int[] total = new int[nums.length];
        
        // if the first element is used
        total[0] = nums[0];
        total[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i]);
        }
        use = total[nums.length - 2];
        
        // if the first element is not used
        total[0] = 0;
        total[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i]);
        }
        unuse = total[nums.length - 1];
        
        return Math.max(use, unuse);
    }
	
	public static void main(String args[]) {
		int[] nums = {1, 1, 1, 2};
		System.out.println(rob(nums));
	}
}