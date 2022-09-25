class Solution {
    private boolean check(String w1, int i, String w2, int j){      
        while(i < w1.length() && j < w2.length()){
            if(w1.charAt(i) == w2.charAt(j)){
                i++;
                j++;
            }
            else if(w1.charAt(i) > w2.charAt(j)){
                return true;
            }else{
                return false;
            }
        }
        if(i < w1.length()){
            return true;
        }
        return false;
    }
    
    public String largestMerge(String word1, String word2) {
        int left = 0, right = 0, temp = 0;
        StringBuilder sb = new StringBuilder();
        while(left < word1.length() && right < word2.length()){
            if(word2.charAt(right) > word1.charAt(left)){
                sb.append(word2.charAt(right ++));
            }
            else if(word1.charAt(left) > word2.charAt(right)){
                sb.append(word1.charAt(left ++));
            }
            else{
                if(!check(word1, left, word2, right)){
                    sb.append(word2.charAt(right ++));
                }
                else {
                    sb.append(word1.charAt(left ++));
                }
            }
        }
        
        while(left < word1.length()) sb.append(word1.charAt(left ++));
        while(right < word2.length()) sb.append(word2.charAt(right ++));
        
        return sb.toString();
    }
}