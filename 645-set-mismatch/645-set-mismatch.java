class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int dup = 0, sum = 0;
        for(int num : nums){
            if(set.contains(num)) dup = num;
            else set.add(num);
            sum += num;
        }
        int expected = (nums.length * (nums.length + 1)) / 2;
        expected = expected - sum + dup;
        return new int[]{dup, expected};
    }
}