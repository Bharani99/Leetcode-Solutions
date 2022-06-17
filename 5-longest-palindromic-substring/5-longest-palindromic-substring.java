class Solution {
    public int count(char[] c, int left, int right){
        int curr = 0;
        while(left >= 0 && right < c.length){
            if(c[left--] != c[right++]) return curr;
            else curr += 2;
        }
        return curr;
    }
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int ans = 0, curr = 0, left = 0, right = 0, mid;
        for(int i = 0; i < c.length; i++){
            curr = count(c, i, i) - 1;
            if(ans < curr){
                ans = Math.max(ans, curr);
                mid = (curr - 1) / 2;
                left = i - mid;
                right = i + mid;
            }
        }
        for(int i = 0; i < c.length; i++){
            curr = count(c, i, i + 1);
            if(ans < curr){
                ans = Math.max(ans, curr);
                mid = (curr) / 2;
                left = i - mid + 1;
                right = i + mid;
            }        
        }
        return s.substring(left, right + 1);
    }
}