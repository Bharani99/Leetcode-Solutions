class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> unique = new HashSet<>();
        int len = s.length();
        for(int i = 0; i <= len - k; i++){
            unique.add(s.substring(i, i + k));
        }
        return unique.size() == 1 << k;
    }
}