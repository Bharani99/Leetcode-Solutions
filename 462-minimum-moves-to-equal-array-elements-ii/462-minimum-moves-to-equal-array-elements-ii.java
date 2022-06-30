class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length % 2 == 1) ? nums[nums.length / 2] : (nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2;
        int ans = 0;
        for(int num : nums){
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}