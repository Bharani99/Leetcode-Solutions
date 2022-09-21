class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int num : nums){
            sum += (num % 2 == 0) ? num : 0;
        }
        int[] ans = new int[queries.length];
        int i = 0, prev;
        for(int[] query : queries){
            prev = nums[query[1]];
            if(prev % 2 == 0) sum -= prev;
            nums[query[1]] += query[0];
            if(nums[query[1]] % 2 == 0) sum += nums[query[1]];
            ans[i++] = sum;
        }
        return ans;
    }
}