package weeklyContest.WC_55;

public class BuyAndSell {

	public static void main(String[] args) {
		BuyAndSell bas = new BuyAndSell();
		int[] prices = { 1, 3, 10, 5, 9, 3 };
		int res = bas.maxProfit(prices, 3);
		System.out.println(res);
	}

	public int maxProfit(int[] prices, int fee) {
		int cost = 0;
		int hold = -prices[0];
		for (int i : prices) {
			cost = Math.max(cost, hold + i - fee);

			/*
			 * cost = Math.max(cost, hold + i - fee); hold = Math.max(hold, cost
			 * - i);
			 */
		}
		return cost;
	}
}
