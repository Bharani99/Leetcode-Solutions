class Solution {
    public int maxProfit(int[] prices, int k, int index, int state, int[][][] dp){
        if(index == prices.length) return 0;
        if(k == 0 && state == 0) return 0;
        if(dp[state][k][index] != -1) return dp[state][k][index];
        
        int sum = 0;
        if(state == 0){
            sum = -prices[index] + maxProfit(prices, k - 1, index + 1, 1, dp);
        }
        else{
            sum = prices[index] + maxProfit(prices, k, index + 1, 0, dp);
        }
        
        sum = Math.max(sum, maxProfit(prices, k, index + 1, state, dp));
        dp[state][k][index] = sum;
        return sum;
    }
    
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[2][k + 1][prices.length];
        for(int[][] d1 : dp) 
            for(int[] d : d1)
                Arrays.fill(d, -1);
        
        return maxProfit(prices, k, 0, 0, dp);
    }
}