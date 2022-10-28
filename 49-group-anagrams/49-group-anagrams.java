class Solution {
    public long getHash(String word){
        int[] count = new int[26];
        for(char c : word.toCharArray()) count[c - 'a']++;
        long hash = 0;
        for(int i = 0; i < 26; i++) hash = hash * 10 + count[i];
        return hash;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set;
        for(int i = 0; i < strs.length; i++){
            long hash = getHash(strs[i]);
            set = map.getOrDefault(hash, new HashSet<>());
            set.add(i);
            map.put(hash, set);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(long key : map.keySet()){
            List<String> in = new ArrayList<>();
            for(int i : map.get(key))in.add(strs[i]);
            ans.add(in);
        }
        return ans;
    }
}