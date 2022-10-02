class Solution {
    int mod = (int)(1e9 + 7);
    long[][] dp;
    public long count(int n, int k, long sum, int target) {
        if(n == 0){
            return sum == target ? 1 : 0;
        }
        if(sum > target) return 0;
        if(dp[n][(int)sum] != -1) return dp[n][(int)sum];
        
        Long ans = 0L;
        for(int i = 1; i <= k; i++){
            ans = (ans + count(n - 1, k, sum + i, target)) % mod;
        }
        dp[n][(int)sum] = ans;
        
        return ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new long[n + 1][target + 1];
        for(long[] d : dp) Arrays.fill(d, -1);
        return (int)(count(n, k, 0, target) % mod);
    }
}