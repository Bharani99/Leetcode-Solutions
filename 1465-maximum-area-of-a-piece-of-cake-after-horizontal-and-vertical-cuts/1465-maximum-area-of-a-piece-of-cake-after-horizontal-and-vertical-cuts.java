class Solution {
    static long MOD = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long hm = horizontalCuts[0];
        long vm = verticalCuts[0];
        
        for(int i = 0; i < horizontalCuts.length-1; i++)
            hm = Math.max(hm, horizontalCuts[i+1] - horizontalCuts[i]);
        
        hm = Math.max(hm, h - horizontalCuts[horizontalCuts.length-1]);
            
        for(int i = 0; i < verticalCuts.length-1; i++)
            vm = Math.max(vm, verticalCuts[i+1] - verticalCuts[i]);
        
        vm = Math.max(vm, w - verticalCuts[verticalCuts.length-1]);
        
        return (int) ((hm * vm) % MOD);
    }
}