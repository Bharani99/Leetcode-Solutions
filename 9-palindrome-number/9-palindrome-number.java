class Solution {
    public boolean isPalindrome(int x) {
        int num = 0, curr = x;
        while(curr > 0){
            num *= 10;
            num += curr % 10;
            curr /= 10;
        }
        return num == x;
    }
}