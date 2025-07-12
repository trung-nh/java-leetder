package neet_code.sliding_window;

public class _121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buyDay = 0; //Assume 0 day as buying day
        int maxProfit = 0;

        for (int sellDay = 0; sellDay < prices.length; sellDay++) {
            if (maxProfit < (prices[sellDay] - prices[buyDay])) {
                maxProfit = (prices[sellDay] - prices[buyDay]);
            }

            if (prices[sellDay] < prices[buyDay]) {
                buyDay = sellDay;
            }
        }

        return maxProfit;
    }
}
