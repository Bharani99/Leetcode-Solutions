class Solution {
    public boolean backspaceCompare(String s, String t) {
        int left = s.length() - 1, right = t.length() - 1;
        int leftSkip = 0, rightSkip = 0;
        
        while(left >= 0 && right >= 0){
            if(s.charAt(left) == '#') {
                leftSkip++;
                left--;
            }
            else if(t.charAt(right) == '#') {
                rightSkip++;
                right--;
            }
            else{
                if(leftSkip > 0) {
                    leftSkip --;
                    left --;
                }
                else if(rightSkip > 0) {
                    rightSkip--;
                    right--;
                }
                else if(s.charAt(left--) != t.charAt(right--)) 
                    return false;
            }
        }
        
        while(left >= 0){
            if(s.charAt(left) == '#') leftSkip++;
            else if(leftSkip > 0) leftSkip --;
            else return false;
            left--;
        }
        
        while(right >= 0){
            if(t.charAt(right) == '#') rightSkip++;
            else if(rightSkip > 0) rightSkip --;
            else return false;
            right--;
        }
        return left == -1 && right == -1;
    }
}