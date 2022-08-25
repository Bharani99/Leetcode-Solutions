class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        int[] hash = new int[26];
        for(char c : magazine.toCharArray()) hash[c - 'a'] ++;
        
        for(char c : ransomNote.toCharArray()) 
            if(hash[c - 'a'] == 0) return false;
            else hash[c - 'a'] --;
        
        return true;
    }
}