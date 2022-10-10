class Solution {
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        if(s.length == 1) return "";
        
        for(int i = 0; i < s.length; i++){
            if(s[i] != 'a' && s[s.length - i - 1] != 'a' && i != (s.length / 2)){
                s[i] = 'a';
                return new String(s);
            }
        }
        
        if(s[s.length - 1] != 'b' && s[0] != 'b'){
            s[s.length - 1] = 'b';
            return new String(s);
        }
        
        return "";
    }
}