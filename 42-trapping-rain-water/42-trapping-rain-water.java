class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length], right = new int[height.length];
        
        int l = 0;
        for(int i = 0; i < height.length; i++){
            left[i] = l;
            l = Math.max(l, height[i]);
        }
        
        l = 0;
        for(int i = height.length - 1; i >= 0; i--){
            right[i] = l;
            l = Math.max(l, height[i]);
        }
        
        int ans = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(left[i] > height[i] && right[i] > height[i])
                ans += (Math.min(left[i], right[i]) - height[i]);
        }
        
        return ans;
    }
}