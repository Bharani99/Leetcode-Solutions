class Solution {
    public int getIndex(int curr, int[] nums){
        if(nums.length == 1) return 0;
        curr += nums[curr];
        if(curr < 0) return nums.length + (curr % nums.length);
        if(curr >= nums.length) return curr % nums.length;
        else return curr;
    }
    
    public boolean circularArrayLoop(int[] nums, int index) {
        int slow = index, fast = index, n = nums.length, seqLen = 0;
        do{
            slow = getIndex(slow, nums);
            fast = getIndex(getIndex(fast, nums), nums);
        }
        while(slow != fast);

        boolean pos = nums[slow] > 0;
        do{
            slow = getIndex(slow, nums);
            seqLen ++;
            if(pos && nums[slow] < 0) return false;
            if(!pos && nums[slow] > 0) return false;
        }while(slow != fast);
        
        return seqLen > 1;
    }
    
    public boolean circularArrayLoop(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(circularArrayLoop(nums, i)) return true;
        }
        return false;
    }
}