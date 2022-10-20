class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, Character> map = new TreeMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        
        String s = num + "";
        int n = s.length() - 1, curr;
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            curr = Character.getNumericValue(c) * (int)(Math.pow(10, n --));
            if(curr == 0) continue;
            Integer higherKey = map.higherKey(curr);
            
            if(higherKey != null && 
               (higherKey - curr == 1 || higherKey - curr == 10 || higherKey - curr == 100))
                    sb.append(map.get(higherKey - curr) + "" + map.get(higherKey));
            
            else while(curr > 0){
                Integer lowerKey = map.floorKey(curr);
                sb.append(map.get(lowerKey));
                curr -= lowerKey;
            }
        }
        return sb.toString();
    }
}