class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            if(a[1] == b[1]) return Integer.compare(b[0], a[0]);
            else return Integer.compare(b[1], a[1]);
        });
        int ans = 0, i = 0;
        while(truckSize > 0 && i < boxTypes.length){
            if(truckSize >= boxTypes[i][0]){
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
            else {
                ans += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            i++;
        }
        return ans;
    }
}