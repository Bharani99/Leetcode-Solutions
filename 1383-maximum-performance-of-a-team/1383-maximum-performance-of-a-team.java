class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //o - speed, 1 - eff
        int[][] arr = new int[n][2];
        for(int i = 0; i < speed.length; i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        long max = 0, sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += arr[i][0];
            max = Math.max(max, arr[i][1] * sum);
            pq.add(arr[i]);
            if(pq.size() == k) {
                sum -= pq.poll()[0];
            }
        }
        return (int) (max % (long)(1e9 + 7));
    }
}