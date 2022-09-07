class Solution {
    
    public void subSet(List<List<Integer>> output, List<Integer> inner, int[] nums, int index){
        output.add(new ArrayList<>(inner));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            inner.add(nums[i]);
            subSet(output, inner, nums, i + 1);
            inner.remove(inner.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        subSet(output, new ArrayList<>(), nums, 0);
        return output;
    }
}