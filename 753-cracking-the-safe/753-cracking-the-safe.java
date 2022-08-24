class Solution {
    
    public boolean crackSafe(int total, StringBuilder sb, HashSet<String> visited, int n, int k){
        if(visited.size() == total){
            return true;
        }
        
        String reuse = sb.substring(sb.length() - n + 1);
        for(char ch = '0'; ch < '0' + k; ch++){
            reuse += ch;
            if(!visited.contains(reuse)){
                sb.append(ch);
                visited.add(reuse);
                
                if(crackSafe(total, sb, visited, n, k))
                    return true;
                
                visited.remove(reuse);
                sb.deleteCharAt(sb.length() - 1);
            }
            reuse = reuse.substring(0, reuse.length() - 1);
        }
        
        return false;
    }
    
    public String crackSafe(int n, int k) {
        int totalPossible = (int) Math.pow(k, n);
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) sb.append("0");
        
        visited.add(sb.toString());
        
        crackSafe(totalPossible, sb, visited, n, k);
        
        return sb.toString();
    }
}