class Solution {
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    public int[] twoSum(int[] numbers, int target) {
        int other;
        for(int i = 0; i < numbers.length - 1; i++){
            other = binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if(other < numbers.length && numbers[other] == target - numbers[i]) 
                return new int[]{i + 1, other + 1};
        }
        return numbers;
    }
}