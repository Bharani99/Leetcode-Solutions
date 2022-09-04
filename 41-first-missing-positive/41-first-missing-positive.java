class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1, temp;
        boolean isLastPresent = false;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            while(temp != i && temp < nums.length && temp > -1){
                if(temp == nums[temp]) break;
                nums[i] = nums[temp];
                nums[temp] = temp;
                temp = nums[i];
            }
            if(temp == nums.length)isLastPresent = true;
        }
        
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == ans) ans++;
        
        return (isLastPresent && ans == nums.length) ? ans + 1 : ans;
    }
}