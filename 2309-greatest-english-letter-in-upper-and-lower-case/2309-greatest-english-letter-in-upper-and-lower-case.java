class Solution {
    public String greatestLetter(String s) {
        int[] small = new int[26], big = new int[26];
        int max = -1;
        for(char c : s.toCharArray()){
            if(c <= 'z' && c >= 'a'){
                small[c - 'a']++;
                if(big[c - 'a'] > 0 && small[c - 'a'] > 0)
                    max = Math.max(max, c - 'a');
            }
            else{
                big[c - 'A']++;
                if(big[c - 'A'] > 0 && small[c - 'A'] > 0)
                    max = Math.max(max, c - 'A');
            }
        }
        
        return max == -1 ? "" : ((char)('A' + max)) + "";
    }
}