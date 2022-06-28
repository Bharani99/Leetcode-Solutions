class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a']++;
        
        Arrays.sort(count);
        int ans = 0, prev = count[25] + 1;
        for(int i = 25; i >= 0; i--){
            if(count[i] == 0) break;
            if(prev == 0){
                ans += count[i];
                count[i] = prev;
            }
            else if(count[i] >= prev){
                ans += count[i] - prev + 1;
                count[i] = prev - 1;
            }
            prev = count[i];
        }
        return ans;
    }
}