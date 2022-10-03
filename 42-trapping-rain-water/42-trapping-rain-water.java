class Solution {
    public int getTrappedWater(int[] leftMax, int[] rightMax, int[] height){
        int ans = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(leftMax[i] > height[i] && rightMax[i] > height[i])
                ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }
    
    public void setMaxHeights(int[] leftMax, int[] rightMax, int[] height){
        int lmax = 0, rmax = 0;
        for(int i = 0; i < height.length; i++){
            leftMax[i] = lmax;
            rightMax[height.length - i - 1] = rmax;
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[height.length - i - 1]);
        }
    }
    
    public int trap(int[] height) {
        int[] leftMax = new int[height.length], rightMax = new int[height.length];
        setMaxHeights(leftMax, rightMax, height);
        return getTrappedWater(leftMax, rightMax, height);
    }
}