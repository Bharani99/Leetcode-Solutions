class Solution {
    class Node{
        char name;
        Set<Character> equal, notEqual;
        Node(char n){
            name = n;
            equal = new HashSet<>();
            notEqual = new HashSet<>();
        }
    }
    
    public boolean traverse(Node curr, HashSet<Character> seen, HashSet<Character> notEqual, HashMap<Character, Node> map){
        if( seen.contains(curr.name) )return true;
        if( notEqual.contains(curr.name)) return false;
        notEqual.addAll(curr.notEqual);
        seen.add(curr.name);
        for(char next : curr.equal){
            if(!traverse(map.get(next), seen, notEqual, map)) return false;
        }
        return true;
    }
    
    public boolean equationsPossible(String[] equations) {
        HashMap<Character, Node> map = new HashMap<>();
        char a, b;
        HashSet<Character> set;
        Node x, y;
        for(String eq : equations){
            a = eq.charAt(0);
            b = eq.charAt(3);
            x = map.getOrDefault(a, new Node(a));
            y = map.getOrDefault(b, new Node(b));
            if(eq.charAt(1) == '='){
                x.equal.add(b);
                y.equal.add(a);
                if(x.notEqual.contains(b)) return false;
            }
            else {
                if(a == b) return false;
                x.notEqual.add(b);
                y.notEqual.add(a);
                if(x.equal.contains(b)) return false;
            }
            map.put(a, x);
            map.put(b, y);
        }
        
        HashSet<Character> seen = new HashSet<>();
        
        for(char eq : map.keySet()){
            if(seen.size() == map.size()) break;
            if(seen.contains(eq)) continue;
            if(!traverse(map.get(eq), seen, new HashSet<>(), map)) return false;
        }
        
        return true;
    }
}