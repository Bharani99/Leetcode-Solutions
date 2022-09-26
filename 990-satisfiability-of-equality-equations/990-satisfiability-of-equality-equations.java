class Solution {
    public int find(int i, int[] uf){
        if(uf[i] != i) return find(uf[i], uf);
        return i;
    }
    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for(int i = 0; i < 26; i++) uf[i] = i;
        
        for(String eq : equations){
            if(eq.charAt(1) == '=')
                uf[find(eq.charAt(0) - 'a', uf)] = find(eq.charAt(3) - 'a', uf);
        }
        
        for(String eq : equations){
            if(eq.charAt(1) == '!' && uf[find(eq.charAt(0) - 'a', uf)] == find(eq.charAt(3) - 'a', uf) ) return false;
        }
        return true;
    }
}