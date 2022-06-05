class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for(int price : prices){
            sell = Math.max(sell, price - buy);
            buy = Math.min(buy, price);
        }
        return sell;
    }
}