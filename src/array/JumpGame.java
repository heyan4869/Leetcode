package array;

public class JumpGame {
	public static boolean canJump(int[] A) {
		int max = 0;
        for (int i = 0; i < A.length; i++){
            if (i > max)
               return false;
          max = Math.max(A[i] + i,max);
        }
        return true;
	}

	public static void main(String args[]) {
		int[] A = new int[5];
		A[0] = 3;
		A[1] = 2;
		A[2] = 1;
		A[3] = 0;
		A[4] = 4;
		System.out.println(canJump(A));
	}
}