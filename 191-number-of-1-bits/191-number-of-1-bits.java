public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String x = Integer.toBinaryString(n);
        int ans = 0;
        for(char c : x.toCharArray())
            if(c == '1') ans++;
        return ans;
    }
}