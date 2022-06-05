class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = 1, minEnding = 1, max = Integer.MIN_VALUE, temp;
        for(int num : nums){
            temp = maxEnding;
            maxEnding = Math.max(num, Math.max(num * maxEnding, num * minEnding));
            minEnding = Math.min(num, Math.min(num * minEnding, num * temp));
            max = Math.max(maxEnding, max);
        }
        return max;
    }
}