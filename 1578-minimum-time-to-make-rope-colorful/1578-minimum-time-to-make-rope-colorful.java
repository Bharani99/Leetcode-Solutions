class Solution {
    public int minCost(char[] colors, int index, char prev, int[] neededTime, int[][] dp){
        if(index == colors.length) return 0;
        
        if(dp[prev - 'a'][index] != Integer.MAX_VALUE) return dp[prev - 'a'][index];
        
        int ans = Integer.MAX_VALUE;
        if(colors[index] != prev){
            ans = minCost(colors, index + 1, colors[index], neededTime, dp);
        }
        
        ans = Math.min(ans, neededTime[index] + minCost(colors, index + 1, prev, neededTime, dp));
        
        dp[prev - 'a'][index] = ans;
        return ans;
    }
    public int minCost(String colors, int[] neededTime) {
        int[][] dp = new int[27][colors.length()];
        for(int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        return minCost(colors.toCharArray(), 0, (char)('z' + 1), neededTime, dp);
    }
}