class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = 0, curr;
        for(int i = 0; i < nums.length; i++){
            curr = Math.abs(nums[i]);
            if(nums[curr - 1] < 0) dup = curr;
            else nums[curr - 1] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return new int[]{dup, i + 1};
        }
        return null;
    }
}