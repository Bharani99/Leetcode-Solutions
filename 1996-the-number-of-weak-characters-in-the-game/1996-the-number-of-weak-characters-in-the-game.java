class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0, max = 0;
        
        Arrays.sort(properties, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });
        
        for(int[] p : properties){
            if(p[1] < max) ans++;
            max = Math.max(p[1], max);
        }
        
        return ans;
    }
}