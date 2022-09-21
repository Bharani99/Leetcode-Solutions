class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[129];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        int ans = 0, odd = 0;
        for(int val : count){
            if(val % 2 == 0) ans += val;
            else {
                ans += val - 1;
                odd = 1;
            }
        }
        return ans + odd;
    }
}