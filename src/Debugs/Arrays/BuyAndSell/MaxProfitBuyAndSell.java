package Debugs.Arrays.BuyAndSell;

public class MaxProfitBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {3, 4, 1, 5};
//        maxProfit(prices);
        MaxProfitBuyAndSell obj = new MaxProfitBuyAndSell();
        obj.maxProfit(prices);
    }

    private void maxProfit(int[] prices) {
        // Initialising maxProfit = 0
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit = maxProfit + (prices[i] - prices[i-1]);
            }

        }
        System.out.println("Max Profit = "+maxProfit);
    }
}
