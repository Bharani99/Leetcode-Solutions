class Solution {
    public void perm(int[] nums, List<Integer> ind, List<List<Integer>> output, List<Integer> inner){
        if(ind.isEmpty()){
            output.add(new ArrayList<>(inner));
            return;
        }
        List<Integer> temp = new ArrayList(ind);
        for(int index : ind){
            inner.add(nums[index]);
            temp.remove(new Integer(index));
            perm(nums, temp, output, inner);
            temp.add(index);
            inner.remove(inner.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ind = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)ind.add(i);
        List<List<Integer>> output = new ArrayList<>();
        perm(nums, ind, output, new ArrayList<>());
        return output;
    }
}