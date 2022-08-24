class Solution {
    public boolean isValid(char c){
        return (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(!isValid(s.charAt(left))) left++;
            else if(!isValid(s.charAt(right))) right --;
            else if(s.charAt(left ++) != s.charAt(right --))
                return false;
        }
        return true;
    }
}