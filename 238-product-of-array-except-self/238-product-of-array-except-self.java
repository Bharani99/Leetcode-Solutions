class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1, n = nums.length;
        int[] leftProd = new int[nums.length], rightProd = new int[nums.length];
        for(int i = 0; i < n; i++){
            leftProd[i] = left;
            rightProd[n - i - 1] = right;
            left *= nums[i];
            right *= nums[n - i - 1];
        }
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = leftProd[i] * rightProd[i];
        
        return ans;
    }
}