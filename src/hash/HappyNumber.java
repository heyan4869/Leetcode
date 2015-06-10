package hash;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public static boolean isHappy(int n) {
        if (n <= 0) {
        	return false;
        }
    	Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
    	return assist(n, hm);
    }
    
    public static boolean assist(int n, Map<Integer, Boolean> hm) {
		if (n == 1) {
			return true;
		}
		if (hm.containsKey(n)) {
			return false;
		} else {
			int sum = 0;
			int backup = n;
			while (n != 0) {
				int temp = n % 10;
				sum = sum + temp * temp;
				n = n / 10;
			}
			if (sum == 1) {
				return true;
			} else {
				hm.put(backup, false);
				n = sum;
				return assist(n, hm);
			}
		}
	}

	public static void main(String args[]) {
    	int n = 19;
    	System.out.println(isHappy(n));
    }
}