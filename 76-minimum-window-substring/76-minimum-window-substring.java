class Solution {
    public int[] getHash(String t){
        int[] hash = new int[52];
        for(char c : t.toCharArray()){
            if(c < 'a')hash[c - 'A']++;
            else hash[c - 'a' + 26]++;
        }
        return hash;
    }
    
    public boolean validHash(int[] s, int[] t){
        for(int i = 0; i < 52; i++){
            if(s[i] < t[i]) return false;
        }
        return true;
    }
    
    public String minWindow(String S, String t) {
        int m = t.length();
        if(m > S.length()) return "";
        int[] tHash = getHash(t);
        int[] sHash = new int[52];
        
        int left = 0, right = 0;
        char[] s = S.toCharArray();
        char c;
        int min = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;
        
        while(right < s.length){
            c = s[right];
            if(c < 'a') sHash[c - 'A']++;
            else sHash[c - 'a' + 26]++;
            
            right++;
            
            while(right - left >= m){
                if(validHash(sHash, tHash)){
                    if(min > (right - left)){
                        min = right - left;
                        minRight = right;
                        minLeft = left;
                    }
                    c = s[left];
                    if(c < 'a') sHash[c - 'A']--;
                    else sHash[c - 'a' + 26]--;
                    left++;
                }
                else break;
            }
        }
        
        return S.substring(minLeft, minRight);
    }
}