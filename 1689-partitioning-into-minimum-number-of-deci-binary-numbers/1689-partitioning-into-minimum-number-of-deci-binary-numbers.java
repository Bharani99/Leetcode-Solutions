class Solution {
    public int minPartitions(String n) {
        if(n.length() == 0 || n.charAt(0) == '0') return 0;
        int len = n.length();
        char[] digits = n.toCharArray();
        int ones = len, zero = 0, first = digits[0]-'0', ans = first, nextStart = len + 1;
        for(int i = 0; i < len; i++){
            if(digits[i] - '0' <= first)
                digits[i] = '0';
            else{
                digits[i] = (char)(((digits[i] - '0') - first) + '0');
                nextStart = Math.min(nextStart, i);
            }
        }
        if(nextStart == len + 1) return ans;
        else return ans + minPartitions(new String(digits).substring(nextStart));
    }
}