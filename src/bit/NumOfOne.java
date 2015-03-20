package bit;

public class NumOfOne {
	public static int countOne(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}

		return count;
	}

	public static void main(String args[]) {
		int n = 11;
		System.out.println(countOne(n));
	}
}
