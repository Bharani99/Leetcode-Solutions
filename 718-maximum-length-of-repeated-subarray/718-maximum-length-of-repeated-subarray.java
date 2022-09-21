class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1], temp;
        int max = 0;
        for(int i = 1; i <= nums1.length; i++){
            temp = new int[nums2.length + 1];
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    temp[j] = 1 + dp[j - 1];
                    max = Math.max(max, temp[j]);
                }
            }
            dp = temp;
        }
        return max;
    }
}