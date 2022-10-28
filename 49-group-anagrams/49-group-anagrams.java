class Solution {
    public long getHash(String word){
        int[] count = new int[26];
        for(char c : word.toCharArray()) count[c - 'a']++;
        long hash = 0;
        for(int i = 0; i < 26; i++) hash = hash * 10 + count[i];
        return hash;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();
        List<String> set;
        for(int i = 0; i < strs.length; i++){
            long hash = getHash(strs[i]);
            set = map.getOrDefault(hash, new ArrayList<>());
            set.add(strs[i]);
            map.put(hash, set);
        }
        
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}