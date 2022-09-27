class Solution {
    public int firstFall(char[] sb, int start){
        while(start < sb.length && sb[start] == '.') start++;
        return start;
    }
    
    public void pushToRight(char[] sb, int left, int right){
        while(left < right)
            sb[left++] = 'R';
    }
    
    public void flip(char[] sb, int left, int right){
        while(left < right){
            sb[left++] = 'R';
            sb[right--] = 'L';
        }
    }
    
    public String pushDominoes(String dominoes) {
        char[] sb = dominoes.toCharArray();
        int left = 0, right;
        while(left < sb.length){
            if(sb[left] == 'L'){
                int temp = left - 1;
                while(temp >= 0 && sb[temp] == '.') sb[temp--] = 'L';
                left++;
            }
            else if(sb[left] == 'R'){
                while(left + 1 < sb.length && sb[left + 1] == 'R') left++;
                right = firstFall(sb, left + 1);
                if(right == sb.length || sb[right] == 'R') {
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
        return new String(sb);
    }
}