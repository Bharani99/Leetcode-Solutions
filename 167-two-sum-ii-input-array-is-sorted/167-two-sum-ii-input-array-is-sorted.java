class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1, val;
        while(left < right){
            val = nums[left] + nums[right];
            if(val == target) return new int[] {left + 1, right + 1};
            if(val < target) left++;
            else right--;
        }
        return null;
    }
}