class Solution {
    public int firstFall(StringBuilder sb, int start){
        while(start < sb.length() && sb.charAt(start) == '.') start++;
        return start;
    }
    
    public void pushToRight(StringBuilder sb, int left, int right){
        while(left < right)
            sb.setCharAt(left++, 'R');
    }
    
    public void flip(StringBuilder sb, int left, int right){
        while(left < right){
            sb.setCharAt(left++, 'R');
            sb.setCharAt(right--, 'L');
        }
    }
    
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int left = 0, right;
        while(left <= sb.length() - 1){
            if(sb.charAt(left) == 'L'){
                int temp = left - 1;
                while(temp >= 0 && sb.charAt(temp) == '.') sb.setCharAt(temp--, 'L');
                left++;
            }
            else if(sb.charAt(left) == 'R'){
                while(left + 1 < sb.length() && sb.charAt(left + 1) == 'R') left++;
                right = firstFall(sb, left + 1);
                if(right == sb.length() || sb.charAt(right) == 'R') {
                    pushToRight(sb, left, right);
                    left = right;
                }
                else {
                    flip(sb, left, right);
                    left = right + 1;
                }
            }
            else left++;
        }
        return sb.toString();
    }
}