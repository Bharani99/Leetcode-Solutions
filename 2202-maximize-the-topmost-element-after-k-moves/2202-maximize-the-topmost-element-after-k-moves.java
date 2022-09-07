class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k % 2 == 1 && nums.length == 1) return -1;
        int ans = -1;
        if(k <= nums.length){
            for(int i = 0; i < k - 1; i++){
                ans = Math.max(ans, nums[i]);
            }
            if(k < nums.length) ans = Math.max(ans, nums[k]);
        }
        else{
            for(int num : nums) ans = Math.max(ans, num);
        }
        return ans;
    }
}