class Solution {
    public int missingNumber(int[] nums) {
        int temp, ans = nums.length;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            while(temp != i && temp < nums.length){
                nums[i] = nums[temp];
                nums[temp] = temp;
                temp = nums[i];
            }
            if(temp != i) ans = i;
        }
        return ans;
    }
}