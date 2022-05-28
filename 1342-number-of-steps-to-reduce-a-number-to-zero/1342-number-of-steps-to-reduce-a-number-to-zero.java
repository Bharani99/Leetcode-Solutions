class Solution {
    public int numberOfSteps(int num) {
        if(num == 0) return 0;
        int ans = 0;
        while (num > 1){
            if((num & 1) == 1) ans += 2;
            else ans++;
            num = num >> 1;
        }
        return ++ans;
    }
}