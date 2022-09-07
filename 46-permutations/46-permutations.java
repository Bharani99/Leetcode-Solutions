class Solution {
    public void perm(int[] nums, HashSet<Integer> ind, HashSet<Integer> temp, List<List<Integer>> output, List<Integer> inner){
        if(ind.isEmpty()){
            output.add(new ArrayList<>(inner));
            return;
        }
        temp = new HashSet(ind);
        for(int index : ind){
            inner.add(nums[index]);
            temp.remove(index);
            perm(nums, temp, null, output, inner);
            temp.add(index);
            inner.remove(inner.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> ind = new HashSet<>();
        for(int i = 0; i < nums.length; i++)ind.add(i);
        List<List<Integer>> output = new ArrayList<>();
        perm(nums, ind, null, output, new ArrayList<>());
        return output;
    }
}