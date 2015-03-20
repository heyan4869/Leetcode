package bit;

public class ReverseBit {
	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int rev = 0;
		for (int i = 0; i < 32; i++) {
			int curr = (1 << i) & n;
			if (curr != 0) {
				rev = (rev << 1) + 1;
			} else {
				rev = rev << 1;
			}
		}
		return rev;
	}

	public static void main(String args[]) {
		int n = 43261596;
		//int temp = 1;
		// System.out.println(1 << 1);
		System.out.println(reverseBits(n));
	}
}