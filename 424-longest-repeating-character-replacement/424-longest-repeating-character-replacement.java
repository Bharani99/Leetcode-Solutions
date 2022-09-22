class Solution {
    public int characterReplacement(String S, int k) {
        int[] count = new int[26];
        char[] s = S.toCharArray();
        int left = 0, right = 0;
        int longest = 0, ans = 0, replace;
        char c;
        while(right < s.length){
            c = s[right ++];
            count[c - 'A']++;
            longest = Math.max(longest, count[c - 'A']);
            while(right - left - longest > k){
                count[s[left] - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}