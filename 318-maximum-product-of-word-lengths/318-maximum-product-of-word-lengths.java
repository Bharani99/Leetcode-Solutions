class Solution {
    public boolean allOne(String x, String y){
        // System.out.println(x +" " + y);

        int left = x.length() - 1, right = y.length() - 1;
        while(left >= 0 && right >= 0){
            if(x.charAt(left) == '1' && x.charAt(left) == y.charAt(right))
                return false;
            left --;
            right --;
        }
        return true;
    }
    public int maxProduct(String[] words) {
        String[] hash = new String[words.length];
        for(int i = 0; i < words.length; i++){
            int[] temp = new int[26];
            for(char c : words[i].toCharArray()){
                temp[c - 'a'] = 1;
                
            }
            StringBuilder num = new StringBuilder();
            for(int j = 0; j < 26; j++){
                num.append(temp[j]);
            }
            hash[i] = num.toString();
        }
        int max = 0;
        
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if( allOne(hash[i] , hash[j]) ) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}