// https://leetcode.com/problemset/top-amazon-questions/

class StocksSolution{

    public int maxProfit(int[] prices){
        int maxProf = 0;

        for(int i = 0; i < prices.length - 1; i++){
            int buyVal = prices[i];
            for(int j = i + 1; j < prices.length; j ++){
                if(prices[j] > buyVal && (prices[j] - buyVal > maxProf)) { 
                    maxProf = prices[j] - buyVal;
                }
            }
        }
        return maxProf;
    }

    public static void main(String[] args){
        StocksSolution classObj = new StocksSolution();
        int[] somePrices = {7, 1, 5, 3, 6, 4};
        System.out.println(classObj.maxProfit(somePrices));

    }
}