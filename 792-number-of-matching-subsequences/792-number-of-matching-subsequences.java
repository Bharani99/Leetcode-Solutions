class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        TreeSet<Integer> inner;
        char letter;
        for(int i = 0; i < s.length(); i++){
            letter = s.charAt(i);
            inner = map.getOrDefault(letter, new TreeSet<>());
            inner.add(i);
            map.put(letter, inner);
        }
        int ans = 0, index = -1;
        Integer next;
        boolean present = true;
        for(String word : words){
            present = true;
            for(char c : word.toCharArray()){
                if(!map.containsKey(c)){
                    present = false;
                    break;
                }
                inner = map.get(c);
                next = inner.higher(index);
                if(next == null){
                    present = false;
                    break;
                }
                index = next;
            }
            if(present) ans++;
            index = -1;
        }
        return ans;
    }
}