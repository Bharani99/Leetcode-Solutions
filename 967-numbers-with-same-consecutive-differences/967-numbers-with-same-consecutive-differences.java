class Solution {
    public void genSeq(int n, int k, int curr, int soFar, ArrayList<Integer> list){
        if(curr < 0 || curr > 9) return;
        if(n == 0) {
            list.add(soFar * 10 + curr);
            return;
        }
        genSeq(n - 1, k, curr + k, soFar * 10 + curr, list);
        if(k != 0) genSeq(n - 1, k, curr - k, soFar * 10 + curr, list);
    }
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            genSeq(n - 1, k, i, 0, ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}