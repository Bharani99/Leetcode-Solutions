class Solution {
    public String greatestLetter(String s) {
        int[] small = new int[26], big = new int[26];
        for(char c : s.toCharArray()){
            if(c <= 'z' && c >= 'a'){
                small[c - 'a']++;
            }
            else{
                big[c - 'A']++;
            }
        }
        for(int i = 25; i >= 0; i--)
            if(big[i] > 0 && small[i] > 0)
                return ((char)('A' + i)) + "";
        return "";
    }
}