class Solution {
    public void dfs(List<String> output, char[] s, int index, StringBuilder sb){
        if(index == s.length){
            output.add(sb.toString());
            return;
        }
        
        sb.append(s[index]);
        dfs(output, s, index + 1, sb);
        sb.deleteCharAt(index);
        
        if(s[index] >= 'a' && s[index] <= 'z'){
            sb.append((char)(s[index] - 32));
            dfs(output, s, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> output = new ArrayList<>();
        dfs(output, s.toLowerCase().toCharArray(), 0, new StringBuilder());
        return output;
    }
}