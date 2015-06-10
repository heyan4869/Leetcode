package dp;

public class BuySellStockIII {
	public static int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		
		// first transaction max profit
		int[] first = new int[prices.length];
		first[0] = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			first[i] = Math.max(first[i - 1], prices[i] - minPrice);
		}

		// second transaction max profit
		int[] second = new int[prices.length];
		second[prices.length - 1] = 0;
		int maxPrice = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			second[i] = Math.max(second[i + 1], maxPrice - prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, first[i] + second[i]);
		}

		return profit;
	}

	public static int maxProf(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = 0;
		for (int i = 1; i < prices.length - 2; i++) {
			int temp = helper(prices, 0, i)
					+ helper(prices, i + 1, prices.length - 1);
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	public static int helper(int[] prices, int begin, int end) {
		int min = prices[begin];
		int profit = 0;

		for (int i = begin + 1; i <= end; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > profit) {
					profit = prices[i] - min;
				}

			}
		}

		return profit;
	}

	public static int findMax(int[] prices, int begin, int end) {
		if (begin < 0 || end >= prices.length || begin > end) {
			return 0;
		}
		int curr = 0;
		int temp = 0;

		curr = Math.max(findMax(prices, begin + 1, end),
				findMax(prices, begin, end - 1));
		curr = Math.max(curr, prices[end] - prices[begin]);

		for (int i = begin + 1; i < end; i++) {
			temp = findMax(prices, begin, i) + findMax(prices, i + 1, end);
			curr = Math.max(curr, temp);
		}

		return curr;
	}

	public static int maxPro(int[] prices) {
		if (prices.length == 0)
			return 0;

		int min = prices[0];
		int profit = 0;
		int first = 0;
		int second = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > profit) {
					profit = prices[i] - min;
				}
			}

			int minfirst = prices[0];
			for (int j = 1; j <= i; j++) {
				if (prices[j] < minfirst) {
					minfirst = prices[j];
				} else {
					if (prices[j] - min > first) {
						first = prices[j] - minfirst;
					}
				}
			}

			int minsecond = prices[i];
			for (int k = i + 1; k < prices.length; k++) {
				if (prices[k] < minsecond) {
					minsecond = prices[k];
				} else {
					if (prices[k] - minsecond > second) {
						second = prices[k] - minsecond;
					}
				}
			}

			if (first + second > profit) {
				profit = first + second;
			} else {
				first = 0;
				second = 0;
			}

		}

		return profit;
	}

	public static void main(String args[]) {
		int[] prices = { 2, 1, 3, 4, 2, 6, 7, 9 };
		System.out.println(maxProfit(prices));
	}
}