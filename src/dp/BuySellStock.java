package dp;

public class BuySellStock {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		
		int min = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > profit) {
					profit = prices[i] - min;
				}

			}
		}
		// return findMax(prices, 0, prices.length - 1);
		return profit;
	}

	// try to use recursion, but time exceeded
	public static int findMax(int[] prices, int begin, int end) {
		if (begin < 0 || end >= prices.length || begin > end) {
			return 0;
		}
		int curr = 0;
		if (begin < end) {
			curr = Math.max(findMax(prices, begin + 1, end),
					findMax(prices, begin, end - 1));
			curr = Math.max(curr, prices[end] - prices[begin]);
		}

		return curr;
	}

	public static void main(String args[]) {
		int[] prices = { 2, 2, 3, 4, 2, 6, 7 };
		System.out.println(maxProfit(prices));
	}
}