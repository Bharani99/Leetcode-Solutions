class Solution {
    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        Queue<StringBuilder> q = new LinkedList<>();
        int size = 0;
        q.add(new StringBuilder());
        StringBuilder temp;
        
        for(char c : s.toCharArray()){
            size = q.size();
            for(int i = 0; i < size; i++){
                temp = q.poll();
                temp.append(c);
                q.add(new StringBuilder(temp));
                if(c >= 'a' && c <= 'z'){
                    temp.deleteCharAt(temp.length() - 1);
                    temp.append((char)(c - 32));
                    q.add(temp);
                }
            }
        }
        
        List<String> output = new ArrayList<>();
        while(!q.isEmpty()) output.add(q.poll().toString());
        return output;
    }
}