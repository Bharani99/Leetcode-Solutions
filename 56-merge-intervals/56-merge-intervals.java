class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> output = new ArrayList<>();
        int size = 0;
        int[] prev;
        for(int[] interval : intervals){
            if(size == 0) {
                output.add(interval);
                size++;
            }
            else{
                prev = output.get(size - 1);
                if(interval[0] <= prev[1] && interval[0] >= prev[0]){
                    //merge
                    prev[1] = Math.max(prev[1], interval[1]);
                }
                else{
                    output.add(interval);
                    size++;
                }
            }
        }
        int[][] ans = new int[size][2];
        for(int[] inner : output) ans[--size] = inner;
        return ans;
    }
}