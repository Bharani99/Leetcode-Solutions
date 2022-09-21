class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[129];
        int[] tmap = new int[129];
        for(int i = 0; i < 129; i++){
            map[i] = -1;
            tmap[i] = -1;
        }
        int l = 0, r = 0;
        char x, y;
        while(l < s.length()){
            x = s.charAt(l);
            y = t.charAt(l++);
            if(tmap[y] != -1 && tmap[y] != x) return false;
            if(map[x] == -1) {
                map[x] = y;
                tmap[y] = x;
            }
            if(map[x] != y) return false;
        }
        return true;
    }
}