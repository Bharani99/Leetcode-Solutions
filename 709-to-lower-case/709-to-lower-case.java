class Solution {
    public String toLowerCase(String s) {
        char[] given = s.toCharArray();
        char c;
        for(int i = 0; i < given.length; i++){
            c = given[i];
            if(c >= 'A' && c <= 'Z')
                given[i] = (char)(c + 32);
        }
        return String.valueOf(given);
    }
}