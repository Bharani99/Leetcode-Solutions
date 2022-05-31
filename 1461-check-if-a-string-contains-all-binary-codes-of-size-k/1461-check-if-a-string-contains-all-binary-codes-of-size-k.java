class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> unique = new HashSet<>();
        char[] given = s.toCharArray();
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        while(right < given.length){
            sb.append(given[right++]);
            if(right - left == k){
                unique.add(Integer.parseInt(sb.toString(), 2));
                sb.deleteCharAt(0);
                left++;
            }
        }
        return unique.size() == 1 << k;
    }
}