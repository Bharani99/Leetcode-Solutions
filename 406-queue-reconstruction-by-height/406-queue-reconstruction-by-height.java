class Solution {
    
    public void putInFirst(int[][] out, int[] vals){
        int free = 0;
        for(int i = 0; i < out.length; i++){
            if(vals[1] == free && out[i][0] == -1){
                out[i] = vals;
                break;
            }
            else if( (out[i][0] == -1) || out[i][0] == vals[0]) free++;
        }
    }
    
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        int[][] output = new int[people.length][2];
        for(int [] a : output) Arrays.fill(a, -1);
        int[] curr;
        for(int[] person : people) pq.add(person);
        while(!pq.isEmpty()){
            curr = pq.poll();
            putInFirst(output, curr);
        }
        return output;
    }
}