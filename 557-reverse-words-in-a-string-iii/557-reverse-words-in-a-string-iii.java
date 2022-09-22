class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(), temp = new StringBuilder();
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c == ' '){
                temp.reverse();
                sb.append(temp.toString() + " ");
                temp = new StringBuilder();
            }
            else temp.append(c);
        }
        temp.reverse();
        sb.append(temp.toString());
        return sb.toString();
    }
}