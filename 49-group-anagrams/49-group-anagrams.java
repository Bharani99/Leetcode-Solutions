class Solution {
    public String getHash(String word){
        int[] count = new int[26];
        for(char c : word.toCharArray()) count[c - 'a']++;
        StringBuilder hash = new StringBuilder();
        for(int i = 0; i < 26; i++) hash.append(count[i] + "#");
        return hash.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set;
        for(int i = 0; i < strs.length; i++){
            String hash = getHash(strs[i]);
            set = map.getOrDefault(hash, new HashSet<>());
            set.add(i);
            map.put(hash, set);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> in = new ArrayList<>();
            for(int i : map.get(key))in.add(strs[i]);
            ans.add(in);
        }
        return ans;
    }
}