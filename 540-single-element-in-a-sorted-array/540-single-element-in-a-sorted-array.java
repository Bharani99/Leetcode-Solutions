class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length, mid;
        while(left < right){
            if(right - left == 1) return nums[left];
            mid = left + (right - left) / 2;
            if(mid % 2 == 1) mid--;
            if(nums[mid] != nums[mid + 1]) right = mid;
            else left = mid + 2;
        }
        return nums[left];
    }
}