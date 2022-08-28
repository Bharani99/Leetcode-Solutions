class Solution {
    public int[][] diagonalSort(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = mat.length, n = mat[0].length, j, k;
        for(int i = 0; i < m; i++){
            list.clear();
            j = i;
            k = 0;
            while(j < m && k < n){
                list.add(mat[j++][k++]);
            }
            
            Collections.sort(list);
            
            j = i;
            k = 0;
            while(j < m && k < n)
                mat[j++][k] = list.get(k++);
        }
        
        for(int i = 1; i < n; i++){
            list.clear();
            j = 0;
            k = i;
            while(j < m && k < n){
                list.add(mat[j++][k++]);
            }
            
            Collections.sort(list);
            
            j = 0;
            k = i;
            while(j < m && k < n)
                mat[j][k++] = list.get(j++);
        }
        return mat;
    }
}