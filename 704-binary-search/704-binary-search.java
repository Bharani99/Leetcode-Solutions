class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(target <= nums[mid]) right = mid;
            else left = mid + 1;
        }
        return (left < nums.length && nums[left] == target) ? left : -1;
    }
}