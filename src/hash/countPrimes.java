package hash;

import java.util.HashMap;
import java.util.Map;

public class countPrimes {
	public static int countPrimes(int n) {
		if (n == 1 || n == 2) {
			return n - 1;
		}
		int count = 1;
		Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		for (int curr = 3; curr < n; curr = curr + 2) {
			if (!hm.containsKey(curr)) {
				Boolean flag = true;
				for (int temp = 3; temp < curr; temp = temp + 2) {
					if (hm.get(temp) == true) {
						if (curr % temp == 0) {
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					// curr is prime
					hm.put(curr, true);
					count++;
					for (int i = 3; i <= n / curr; i = i + 2) {
						hm.put(i * curr, false);
					}
				} else {
					// curr is not prime
					hm.put(curr, false);
				}
			}
		}
		return count;
	}
	
	public static int count(int n) {
		if (n == 1 || n == 2) {
			return n - 1;
		}
		int count = 1;
		Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		for (int curr = 3; curr < n; curr = curr + 2) {
			if (!hm.containsKey(curr)) {
				hm.put(curr, true);
				count++;
				for (int i = 3; i < n / curr; i = i + 2) {
					hm.put(curr * i, false);
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		System.out.println(count(12));
	}
}