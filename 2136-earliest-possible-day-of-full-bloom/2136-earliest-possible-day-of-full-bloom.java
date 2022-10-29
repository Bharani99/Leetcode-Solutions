class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //0 - pt, 1 - gt
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int max = 0;
        int curr = 0;
        for(int i = 0; i < plantTime.length; i++) 
            pq.add(new int[]{plantTime[i], growTime[i]});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            curr += node[0];
            max = Math.max(max, curr + node[1]);
        }
        return max;
    }
}