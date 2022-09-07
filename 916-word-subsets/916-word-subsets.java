class Solution {
    public int[] getHash(String word){
        int[] hash = new int[26];
        for(char c : word.toCharArray())
            hash[c - 'a']++;
        return hash;
    }
    
    public boolean isSubSet(int[] word, int[] parent){
        for(int i = 0; i < 26; i++){
            if(word[i] > parent[i]) return false;
        }
        return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashSet<String> seen = new HashSet();
        int[] hash = new int[26], small;
        for(String word : words2){
            if(seen.contains(word)) continue;
            seen.add(word);
            small = getHash(word);
            for(int i = 0; i < 26; i++){
                hash[i] = Math.max(hash[i], small[i]);
            }
        }
        
        List<String> output = new ArrayList<>();

        for(String word : words1){
            if(isSubSet(hash, getHash(word)))
                output.add(word);
        }
        
        return output;
    }
}