class Solution {
    public int maximise(int[] nums, int[] m, int left, int right, int index, Integer[][] dp){
        if(index == m.length) return 0;
        if(dp[index][right] != null) return dp[index][right];
        int ans = (nums[left] * m[index]) + maximise(nums, m, left + 1, right, index + 1, dp);
        ans = Math.max(ans, (nums[right] * m[index]) + maximise(nums, m, left, right - 1, index + 1, dp));
        
        dp[index][right] = ans;
        return ans;
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer [][] dp = new Integer[multipliers.length][nums.length];
        return maximise(nums, multipliers, 0, nums.length - 1, 0, dp);
    }
}