class Solution {
    class Node{
        String word;
        int count;
        Node(String w, int c){
            word = w;
            count = c;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if(a.count == b.count)
                return b.word.compareTo(a.word);
            return Integer.compare(a.count, b.count);
        });
        
        for(String key : map.keySet()){
            pq.add(new Node(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }
        
        List<String> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.add(0, pq.poll().word);
        }
        return list;
    }
}