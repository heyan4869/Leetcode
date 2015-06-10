package hash;

import java.util.HashMap;
import java.util.Map;

public class countPrimesFast {
	public static int countPrimes(int n) {
		if (n == 1 || n == 2) {
			return 0;
		}
		int OddNums = n / 2;
		int sum = 0;
		boolean[] primes = new boolean[OddNums];
		// set all odd number to true，2 * n + 3
		for (int i = 0; i < OddNums; i++)
			primes[i] = true;

		for (int i = 0; i < OddNums; i++) {
			int tmpOddNum = 2 * i + 3;
			if (primes[i]) {
				int indexPrime;
				for (int j = 1; (2 * j + 1) * tmpOddNum < n; j++) {
					indexPrime = ((2 * j + 1) * tmpOddNum - 3) / 2;
					primes[indexPrime] = false;
				}
			}
		}
		for (int i = 0; i < OddNums; i++)
			if (primes[i])
				sum++;

		return sum;
	}

	public static void main(String args[]) {
		System.out.println(countPrimes(12));
	}
}