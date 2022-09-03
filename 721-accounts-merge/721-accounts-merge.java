class Solution {
    HashMap<String, HashSet<String>> connected = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    
    public void dfs(List<String> inner, String email){
        if(visited.contains(email)) return;
        visited.add(email);
        inner.add(email);
        for(String next : connected.get(email)){
            dfs(inner, next);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<String> main, other;
        String curr, name, first;
        for(List<String> account : accounts){
            first = account.get(1);
            main = connected.getOrDefault(first, new HashSet<>());
            for(int i = 2; i < account.size(); i++){
                curr = account.get(i);
                other = connected.getOrDefault(curr, new HashSet<>());
                main.add(curr);
                other.add(first);
                connected.put(curr, other);
            }
            connected.put(first, main);
        }
        
        List<List<String>> output = new ArrayList<>();
        
        for(List<String> account : accounts){
            name = account.get(0);
            first = account.get(1);
            if(!visited.contains(first)){
                List<String> inner = new ArrayList<>();
                inner.add(name);
                dfs(inner, first);
                Collections.sort(inner.subList(1, inner.size()));
                output.add(inner);
            }
        }
        return output;
    }
}