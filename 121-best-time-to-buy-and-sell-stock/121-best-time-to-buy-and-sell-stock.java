class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, ans = 0;
        for(int price : prices){
            buy = Math.min(buy, price);
            if(price >= buy) ans = Math.max(price - buy, ans);
        }
        return ans;
    }
}