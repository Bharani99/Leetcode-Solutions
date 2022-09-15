class Solution {
    
    public void updateMap(HashMap<Integer, Integer> map, int num){
        int temp;
        temp = map.get(num) - 1;
        if(temp == 0) map.remove(num);
        else map.put(num, temp);
    }
    
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1) return new int[0];
        Arrays.sort(changed);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[changed.length / 2];
        int index = 0;
        for(int num : changed) map.put(num, map.getOrDefault(num, 0) + 1);
        for(int i = changed.length - 1; i >= 0; i--){
            if(map.containsKey(changed[i])){
                if(changed[i] % 2 == 1 || !map.containsKey(changed[i] / 2)) return new int[0];
                if(map.containsKey(changed[i] / 2)){
                    updateMap(map, changed[i]);
                    updateMap(map, changed[i] / 2);
                    ans[index++] = changed[i] / 2;
                }
                
            }
        }
        return map.isEmpty() ? ans : new int[0];
    }
}