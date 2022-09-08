class Solution {
    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        Queue<String> q = new LinkedList<>();
        int size = 0;
        q.add("");
        String temp;
        
        for(char c : s.toCharArray()){
            size = q.size();
            for(int i = 0; i < size; i++){
                temp = q.poll();
                q.add(temp + c);
                if(c >= 'a' && c <= 'z'){
                    q.add(temp + (char)(c - 32));
                }
            }
        }
        return new ArrayList<>(q);
    }
}