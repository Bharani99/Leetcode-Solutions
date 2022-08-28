class Solution {
    public void twoSum(int[] nums, int target, int index, List<List<Integer>> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> temp;                

        int left = index + 1, right = nums.length - 1;
        
        while(left < right){
            if(nums[left] + nums[right] == target){
                temp = new ArrayList<>();
                temp.add(nums[index]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                list.add(temp);
                while(left + 1 < nums.length && nums[left] == nums[left + 1]) left++;
                while(right > 0 && nums[right] == nums[right - 1]) right --;
                left++;
                right--;
            }
            else if(nums[left] + nums[right] < target)
                left ++;
            else right --;
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, -nums[i], i, list);
        }
        return list;
    }
}