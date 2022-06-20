class Solution {
    Trie root;
    class Trie{
        Trie[] children = new Trie[26];
    }
    public void addWord(String word){
        Trie curr = root;
        char[] w = word.toCharArray();
        for(int i = w.length - 1; i >= 0; i--){
            if(curr.children[w[i] - 'a'] == null)
                curr.children[w[i] - 'a'] = new Trie();
            curr = curr.children[w[i] - 'a'];
        }
    }
    
    public boolean inTrie(String word){
        Trie curr = root;
        char[] w = word.toCharArray();
        for(int i = w.length - 1; i >= 0; i--){
            if(curr.children[w[i] - 'a'] == null) return false;
            curr = curr.children[w[i] - 'a'];
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