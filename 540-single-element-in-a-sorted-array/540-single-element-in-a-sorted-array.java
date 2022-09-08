class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length, mid;
        while(left < right){
            if(right - left == 1) return nums[left];
            mid = left + (right - left) / 2;
            if(mid % 2 == 0) {
                if(mid + 1 == nums.length || (nums[mid] != nums[mid + 1] && mid > 0 && nums[mid] != nums[mid - 1]))
                    return nums[mid];
            }
            else{
                if(mid > 0 && mid + 1 < nums.length && (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]))
                    return nums[mid];
            }
            
            if(mid % 2 == 1){
                if(nums[mid] == nums[mid - 1])
                    left = mid + 1;
                else right = mid;
            }
            else{
                if(nums[mid] != nums[mid - 1])
                    left = mid + 1;
                else right = mid;
            }

        }
        return nums[left];
    }
}