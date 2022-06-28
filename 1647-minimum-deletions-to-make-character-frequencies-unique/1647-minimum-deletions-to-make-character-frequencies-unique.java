class Solution {
    public int minDeletions(String s) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] count = new int[26];
        int temp = 0, ans = 0, changeKey, curr;
        for(char c : s.toCharArray()){
            temp = ++count[c - 'a'];
            if(temp > 1) {
                curr = map.get(temp - 1);
                if(curr == 1) map.remove(temp - 1);
                else map.put(temp - 1, curr - 1);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        if(map.containsKey(0)) map.remove(0);
        Integer key = map.firstKey();
        while(key != null){
            temp = map.get(key);
            while(temp > 1){
                changeKey = key;
                while(map.containsKey(changeKey)) changeKey--;
                ans += key - changeKey;
                if(changeKey != 0) map.put(changeKey, 1);
                temp --;
            }
            map.put(key, 1);
            key = map.higherKey(key);
        }
        return ans;
    }
}