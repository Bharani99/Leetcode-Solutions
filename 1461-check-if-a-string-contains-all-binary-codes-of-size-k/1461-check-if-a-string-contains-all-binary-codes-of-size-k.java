class Solution {
    public boolean hasAllCodes(String s, int k) {
        boolean[] got = new boolean[1 << k];
        int need = got.length;
        char[] given = s.toCharArray();
        int left = 0, right = 0, temp = 0, one = need - 1;
        while(right < given.length){            
            if(right - left + 1 == k){
                temp = ((temp << 1) & one) | (given[right] - '0');
                if(!got[temp]){
                    got[temp] = true;
                    need --;
                }
                left++;
            }
            else temp = (temp << 1) | (given[right] - '0');
            if(need == 0) return true;
            right ++;
        }
        return false;
    }
}