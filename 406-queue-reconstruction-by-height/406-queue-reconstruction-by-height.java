class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(b[0], a[0]);
        });
        List<int[]> out = new ArrayList<>(people.length);
        for(int[] curr : people){
            out.add(curr[1], curr);
        }
        return out.toArray(new int[0][]);
    }
}