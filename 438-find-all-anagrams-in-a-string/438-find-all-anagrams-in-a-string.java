class Solution {
    public List<Integer> findAnagrams(String S, String P) {
        List<Integer> output = new ArrayList<>();
        
        if(P.length() > S.length()) return output;
        
        int[] phash = new int[26];
        int[] temp = new int[26];
        char[] p = P.toCharArray();
        
        for(char c : p) phash[c - 'a']++;
        
        int left = 0, right = 0;
        
        char[] s = S.toCharArray();
        
        while(right < s.length){
            temp[s[right] - 'a'] ++;
            if(temp[s[right] - 'a'] > phash[s[right] - 'a']){
                if(phash[s[right] - 'a'] == 0){
                    temp = new int[26];
                    left = right + 1;
                }
                else{
                    while(temp[s[right] - 'a'] > phash[s[right] - 'a']){
                        temp[s[left] - 'a'] --;
                        left++;
                    }
                }
                
            }
            right ++;
            if(right - left == p.length) output.add(left);
        }
        return output;
    }
}