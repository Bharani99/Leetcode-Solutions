class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for(String w : word1) a.append(w);
        for(String w : word2) b.append(w);
        return a.toString().equals(b.toString());
    }
}