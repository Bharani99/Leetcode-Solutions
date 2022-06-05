class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1, mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[left] < nums[right]){
                right = mid;
            }
            else{
                if(nums[mid] < nums[left]){
                    right = mid;
                }
                else left = mid + 1;
            }
        }
        return nums[left - 1];
    }
}