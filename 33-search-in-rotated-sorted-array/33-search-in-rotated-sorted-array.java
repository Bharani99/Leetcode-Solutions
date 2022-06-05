class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return 0;
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
        return left - 1;
    }

    public int search(int[] nums, int target) {
        int start = findMin(nums);
        int n = nums.length, left = 0, right = n, mid, pivot;
        while(left < right){
            mid = left + (right - left) / 2;
            pivot = (mid + start) % n;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] < target) left = mid + 1;
            else right = mid;       
        }
        return -1;
    }
}