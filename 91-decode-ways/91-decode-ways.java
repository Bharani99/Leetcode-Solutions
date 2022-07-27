class Solution {
    int[][] dp;
    public int countNum (char[] c, int i, int lenSoFar){
        //base
        if(i == c.length)
            return (lenSoFar == 0) ? 1 : 0;
        
        if(dp[lenSoFar][i] != -1) return dp[lenSoFar][i];
        
        //core
        if(lenSoFar == 0 && c[i] == '0') return 0;
        if(lenSoFar == 1 && c[i - 1] == '2' && c[i] > '6') return 0;
        
        int ans = 0;
        if(lenSoFar == 0){
            if(c[i] < '3') ans += countNum(c, i + 1, 1);
            ans += countNum(c, i + 1, 0);
        }
        else ans += countNum(c, i + 1, 0);
        dp[lenSoFar][i] = ans;
        return ans;
        
    }
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        if(c[0] == '0') return 0;
        dp = new int[2][c.length];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        return countNum(c, 0, 0);
    }
}