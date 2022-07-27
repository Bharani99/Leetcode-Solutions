class Solution {
    int[][][] dp;
    public int max(int[] nums, int index, int cool, boolean canPickLast){
        if(index == nums.length - 1){
            if(!canPickLast && cool == 0) return nums[index];
            else return 0;
        }
        if(dp[canPickLast ? 0 : 1][cool][index] != -1) return dp[canPickLast ? 0 : 1][cool][index];
        int ans = 0;
        if(cool == 0){
            ans = nums[index] + max(nums, index + 1, 1, canPickLast || index == 0);
        }
        ans = Math.max(ans, max(nums, index + 1, 0, canPickLast));
        
        dp[canPickLast ? 0 : 1][cool][index] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        dp = new int[2][2][nums.length];
        for(int[][] in : dp){
            for(int [] d : in)
                Arrays.fill(d, -1);
        }
        return max(nums, 0, 0, false);
    }
}