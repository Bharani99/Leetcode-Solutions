class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = mat.length, n = mat[0].length, j, k;
        for(int i = 0; i < m; i++){
            j = i;
            k = 0;
            while(j < m && k < n){
                pq.add(mat[j++][k++]);
            }
                        
            j = i;
            k = 0;
            while(j < m && k < n)
                mat[j++][k++] = pq.poll();
        }
        
        for(int i = 1; i < n; i++){
            j = 0;
            k = i;
            while(j < m && k < n){
                pq.add(mat[j++][k++]);
            }
                        
            j = 0;
            k = i;
            while(j < m && k < n)
                mat[j++][k++] = pq.poll();
        }
        return mat;
    }
}