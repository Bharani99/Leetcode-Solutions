class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int mod = 1000000007;
        for(int i = 1; i <= n; i++){
            ans = ans << (Integer.toBinaryString(i)).length();
            ans = (ans | i) % mod;
        }
        return (int) ans;
    }
}