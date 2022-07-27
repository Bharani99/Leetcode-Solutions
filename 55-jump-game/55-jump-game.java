class Solution {
    public boolean canJump(int[] nums) {
        int currMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > currMax) return false;
            currMax = Math.max(currMax, i + nums[i]);
        }
        return true;
    }
}