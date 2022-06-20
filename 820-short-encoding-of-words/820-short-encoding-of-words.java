class Solution {
    Trie root;
    class Trie{
        HashMap<Character, Trie> children = new HashMap<>(26);
    }
    public void addWord(String word){
        Trie curr = root;
        char[] w = word.toCharArray();
        for(int i = w.length - 1; i >= 0; i--){
            if(!curr.children.containsKey(w[i]))
                curr.children.put(w[i], new Trie());
            curr = curr.children.get(w[i]);
        }
    }
    
    public boolean inTrie(String word){
        Trie curr = root;
        char[] w = word.toCharArray();
        for(int i = w.length - 1; i >= 0; i--){
            if(!curr.children.containsKey(w[i])) return false;
            curr = curr.children.get(w[i]);
        }
        return true;
    }
    
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
        int ans = 0;
        root = new Trie();
        for(String word : words){
            if(!inTrie(word)){
                ans += word.length() + 1;
                addWord(word);
            }
        }
        return ans;
    }
}