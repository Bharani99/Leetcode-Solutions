class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, minSum = 0, min = Integer.MAX_VALUE;
        int total = 0;
        for(int num : nums){
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
            minSum = Math.min(minSum + num, num);
            min = Math.min(min, minSum);
            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}