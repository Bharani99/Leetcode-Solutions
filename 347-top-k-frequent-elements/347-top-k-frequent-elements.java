class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        //count, num
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int key : count.keySet()){
            pq.add(new int[]{count.get(key), key});
            if(pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        while(!pq.isEmpty()) ans[--k] = pq.poll()[1];
        
        return ans;
    }
}