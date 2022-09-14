class Solution {
    
    public int minCost(int[] houses, int[][] cost, int index, int target, int prevColor, int[][][] dp){
        if(target < 0) return Integer.MAX_VALUE;
        if(index == houses.length){
            if(target == 0) return 0;
            else return Integer.MAX_VALUE;
        } 
        
        if(prevColor > -1 && dp[prevColor][target][index] != 0) return dp[prevColor][target][index] == -1 ? 0 : dp[prevColor][target][index];
        
        int ans = Integer.MAX_VALUE, temp;
        if(houses[index] != -1) {
            temp = minCost(houses, cost, index + 1, target - ((prevColor == houses[index]) ? 0 : 1), houses[index], dp);
            if(temp != Integer.MAX_VALUE) ans = temp;
        }
        else if(target == 0){
            temp = minCost(houses, cost, index + 1, target, prevColor, dp);
            if(temp != Integer.MAX_VALUE) ans = cost[index][prevColor] + temp;
        }
        else{
            for(int i = 0; i < cost[index].length; i++){
                temp = minCost(houses, cost, index + 1, target - ((prevColor == i) ? 0 : 1), i, dp);
                if(temp == Integer.MAX_VALUE) continue;
                ans = Math.min(ans, cost[index][i] + temp);
            }
        }
        
        if(prevColor > -1) dp[prevColor][target][index] = ans == 0 ? -1 : ans;
        return ans;
    }
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for(int i = 0; i < m; i++) houses[i]--;
        
        int[][][] dp = new int[n][target + 1][m];
        int temp = minCost(houses, cost, 0, target, -3, dp);
        return temp == Integer.MAX_VALUE ? -1 : temp;
    }
}