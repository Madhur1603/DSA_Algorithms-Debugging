package Debugs.Arrays.BuyAndSell;

public class MaxProfitBuyAndSell_Debugging {
    public static void main(String[] args) {
        int[] prices = {3, 4, 1, 5};
//        maxProfit(prices);
        MaxProfitBuyAndSell_Debugging obj = new MaxProfitBuyAndSell_Debugging();
        obj.maxProfit(prices);
    }

    private void maxProfit(int[] prices) {
        // Initialising maxProfit = 0
        int maxProfit = 0;
        System.out.println("Initialising maxProfit = "+maxProfit);
        for(int i=1; i<prices.length; i++){
            System.out.println();
            System.out.println("Loop iteration = "+i+" , i = "+i);
            if(prices[i] > prices[i-1]){
                System.out.println("\t ( prices["+i+"] > prices["+(i-1)+"] ) -> is true, as prices["+i+"] = "+prices[i]+" is greater then prices["+(i-1)+"] = "+prices[i-1]+"");
                System.out.println("\t So , maxProfit = maxProfit + (prices["+i+"] - prices["+(i-1)+"]) = "+maxProfit+" + ("+prices[i]+" - "+prices[i-1]+")");
                maxProfit = maxProfit + (prices[i] - prices[i-1]);
                System.out.println("\t maxProfit = "+maxProfit);
            }
            else{
                System.out.println("\t ( prices["+i+"] > prices["+(i-1)+"] ) -> is false, as prices["+i+"] = "+prices[i]+" is less then prices["+(i-1)+"] = "+prices[i-1]+"");
                System.out.println("\t So , maxProfit =  "+maxProfit+" , does not change");
            }
        }
        System.out.println();
        System.out.println("Max Profit = "+maxProfit);
    }
}
