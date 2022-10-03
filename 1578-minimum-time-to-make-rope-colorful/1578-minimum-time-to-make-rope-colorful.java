class Solution {
    public int minCost(String color, int[] neededTime) {
        int left = 0, right = 1, ans = 0;
        char[] colors = color.toCharArray();
        while(right < colors.length){
            if(colors[right] == colors[left]){
                if(neededTime[left] < neededTime[right]){
                    ans += neededTime[left];
                    left = right;
                }
                else ans += neededTime[right];
            }
            else left = right;
            right++;
        }
        return ans;
    }
}