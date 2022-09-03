class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < 10; i++)
            q.add(i);
        n--;
        int size = 0, temp, digit;
        while(n > 0){
            size = q.size();
            for(int i = 0; i < size; i++){
                temp = q.poll();
                digit = temp % 10;
                if(digit + k < 10) q.add(temp * 10 + digit + k);
                if(digit - k >= 0 && k != 0) q.add(temp * 10 + digit - k);
            }
            n--;
        }
        
        return q.stream().mapToInt(i -> i).toArray();
    }
}