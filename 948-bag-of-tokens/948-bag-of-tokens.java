class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, left = 0, right = tokens.length - 1, max = score;
        while(left <= right){
            if(tokens[left] <= power){
                power -= tokens[left++];
                score++;
                max = Math.max(max, score);
            }
            else if(score > 0){
                power += tokens[right--];
                score--;
            }
            else break;
        }
        return max;
    }
}