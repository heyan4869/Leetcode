package dp;

public class BuySellStockII {
	public static int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}

		return total;
	}

	public static void main(String args[]) {
		int[] prices = { 2, 2, 3, 4, 2, 6, 7 };
		System.out.println(maxProfit(prices));
	}
}