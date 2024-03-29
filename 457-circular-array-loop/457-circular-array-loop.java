class Solution {
    public int getIndex(int curr, int[] nums){
        if(nums.length == 1) return 0;
        curr += nums[curr];
        if(curr < 0) return nums.length + (curr % nums.length);
        else return curr % nums.length;
    }
    
    public boolean circularArrayLoop(int[] nums, int index) {
        int slow = index, fast = index, n = nums.length, seqLen = 0, temp;
        do{
            slow = getIndex(slow, nums);
            fast = getIndex(getIndex(fast, nums), nums);
        }
        while(slow != fast);

        boolean pos = nums[slow] > 0, result = true;
        do{
            temp = getIndex(slow, nums);
            nums[slow] = 0;
            slow = temp;
            seqLen ++;
            if(pos && nums[slow] < 0) result = false;
            if(!pos && nums[slow] > 0) result = false;
        }while(slow != fast && nums[slow] != 0);
        
        slow = index;
        while(nums[slow] != 0) {
            temp = getIndex(slow, nums);
            nums[slow] = 0;
            slow = temp;
        }
        
        return result && seqLen > 1;
    }
    
    public boolean circularArrayLoop(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && circularArrayLoop(nums, i)) return true;
        }
        return false;
    }
}