package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
    	if (matrix.length == 0) {
    		return res;
    	}
    	int i = 0;
		int j = 0;
		String dir = "right";
		boolean[][] flag = new boolean[matrix.length][matrix[0].length];
		for (int curr = 1; curr <= matrix.length * matrix[0].length; curr++) {
			if (flag[i][j] == false) {
				res.add(matrix[i][j]);
				flag[i][j] = true;
			}
			
			if (dir.equals("right")) {
				if (i < matrix.length && i >= 0 && j + 1 < matrix[0].length && j >= 0) {
					if (flag[i][j + 1] == false) {
						j++;
						// flag = true;
						continue;
					} else {
						dir = "down";
					}
				} else {
					dir = "down";
				}
			}

			if (dir.equals("down")) {
				if (i + 1 < matrix.length && i + 1 >= 0 && j < matrix[0].length && j >= 0) {
					if (flag[i + 1][j] == false) {
						i++;
						// flag = true;
						continue;
					} else {
						dir = "left";
					}
				} else {
					dir = "left";
				}
			}

			if (dir.equals("left")) {
				if (i < matrix.length && i >= 0 && j - 1 >= 0 && j - 1 < matrix[0].length) {
					if (flag[i][j - 1] == false) {
						j--;
						// flag = true;
						continue;
					} else {
						dir = "up";
					}
				} else {
					dir = "up";
				}
			}

			if (dir.equals("up")) {
				if (i - 1 >= 0 && i - 1 < matrix.length && j < matrix[0].length && j >= 0) {
					if (flag[i - 1][j] == false) {
						i--;
						// flag = true;
						continue;
					} else {
						dir = "right";
						j++;
					}
				} else {
					dir = "right";
				}
			}
		}
		
    	return res;
    }
    
    public static void main(String args[]) {
    	int[][] nums = new int[3][3];
    	nums[0][0] = 1;
    	nums[0][1] = 2;
    	nums[0][2] = 3;
    	nums[1][0] = 4;
    	nums[1][1] = 5;
    	nums[1][2] = 6;
    	nums[2][0] = 7;
    	nums[2][1] = 8;
    	nums[2][2] = 9;
    	for (int i = 0; i < nums.length; i++) {
    		for (int j = 0; j < nums[0].length; j++) {
    			System.out.print(" " + nums[i][j] + " ");
    		}
    		System.out.println(" ");
    	}
    	System.out.println(" ");
    	
    	List<Integer> res = spiralOrder(nums);
    	for (int i = 0; i < res.size(); i++) {
    		System.out.print(res.get(i));
    	}
    }
}