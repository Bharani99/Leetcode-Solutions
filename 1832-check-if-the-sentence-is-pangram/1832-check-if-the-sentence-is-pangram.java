class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        int ans = 0;
        for(char c : sentence.toCharArray()){
            if(count[c - 'a'] == 0) ans++;
            count[c - 'a']++;
        }
        return ans == 26;
    }
}