class Solution {
    public int scoreOfParentheses(String s) {
        int res = 0;
        int base = 1;
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (c == '(') {
                base *= 2;
            } else {
                base /= 2;
                if (s.charAt(i - 1) == '(') {
                    res += base;
                }
            }
        }
        return res;
    }
}