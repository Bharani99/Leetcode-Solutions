class Solution {
    int mod = (int)(1e9 + 7);
    HashMap<Integer, HashMap<Long, Long>> map = new HashMap<>();
    public long count(int n, int k, long sum, int target) {
        if(n == 0){
            return sum == target ? 1 : 0;
        }
        if(sum > target) return 0;
        if(map.containsKey(n) && map.get(n).containsKey(sum)) return map.get(n).get(sum);
        
        Long ans = 0L;
        for(int i = 1; i <= k; i++){
            ans = (ans + count(n - 1, k, sum + i, target)) % mod;
        }
        HashMap<Long, Long> set = map.getOrDefault(n, new HashMap<>());
        set.put(sum, ans);
        map.put(n, set);
        
        return ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        return (int)(count(n, k, 0, target) % mod);
    }
}