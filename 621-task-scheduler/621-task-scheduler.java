class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int max = 0, numOfMax = 0;
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
            if(count[task - 'A'] > max){
                max = count[task - 'A'];
                numOfMax = 0;
            }
            if(count[task - 'A'] == max) numOfMax++;
        }
        
        int numOfParts = max - 1;
        int partsLength = (n + 1) * numOfParts;
        int filled = numOfParts * numOfMax; 
        int available = tasks.length - (max * numOfMax);
        int empty = partsLength - filled;
        int idles = Math.max(0, empty - available);
        return tasks.length + idles;
    }
}