class Solution {
    public boolean hasAllCodes(String s, int k) {
        boolean[] got = new boolean[1 << k];
        int need = got.length;
        char[] given = s.toCharArray();
        int left = 0, right = 0, temp;
        StringBuilder sb = new StringBuilder();
        while(right < given.length){
            sb.append(given[right++]);
            if(right - left == k){
                temp = Integer.parseInt(sb.toString(), 2);
                if(!got[temp]){
                    got[temp] = true;
                    need --;
                }
                sb.deleteCharAt(0);
                left++;
            }
            if(need == 0) return true;
        }
        return false;
    }
}