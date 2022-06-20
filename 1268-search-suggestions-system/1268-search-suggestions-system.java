class Solution {
    Trie root;
    class Trie{
        boolean isWord;
        TreeMap<Character, Trie> children = new TreeMap<>();
    }
    void addWord(String word){
        Trie curr = root, temp;
        for(char c : word.toCharArray()){
            temp =  curr.children.getOrDefault(c, new Trie());
            curr.children.put(c, temp);
            curr = temp;
        }
        curr.isWord = true;
    }
    public void find3(List<String> inner, StringBuilder word, Trie curr){
        if(inner.size() == 3) return;
        if(curr.isWord) inner.add(word.toString());
        if(curr.children.size() == 0) return;
        for(char key : curr.children.keySet()){
            if(inner.size() == 3) break;
            word.append(key);
            find3(inner, word, curr.children.get(key));
            word.deleteCharAt(word.length() - 1);
        }
    }
    
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        for(String word : products){
            addWord(word);
        }
        Trie curr = root;
        List<List<String>> output = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        List<String> inner = new ArrayList<>();
        
        for(Character letter : searchWord.toCharArray()){
            if(curr == null || !curr.children.containsKey(letter)){
                break;
            }
            curr = curr.children.get(letter);
            word.append(letter);
            find3(inner, word, curr);
            output.add(new ArrayList<>(inner));
            inner.clear();
        }
        while(output.size() < searchWord.length()) output.add(new ArrayList<>());
        return output;
    }
}