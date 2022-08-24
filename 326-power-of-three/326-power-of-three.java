class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n < 3) return false;
        if(n != (n / 3) * 3) return false;
        return isPowerOfThree(n / 3);
    }
}