class Solution {
    public String getHash(int num){
        int[] hash = new int[10];
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            hash[num % 10]++;
            num /= 10;
        }
        for(int i = 0; i < 10; i++){
            sb.append("#" + i + "#" + hash[i] + "#");
        }
        return sb.toString();
    }
        
    public boolean checkValues(int digits, String hash){
        int[] pattern = new int[]{0, 4, 7};
        int[] end = new int[]{4, 3, 3};
        int bucket = (digits - 1) / 3;
        int start = (digits - 1) % 3;
        int index = bucket * 10 + pattern[start];
        for(int i = 0; i < end[start]; i++){
            if(getHash(1 << index++).equals(hash)) 
                return true;
        }
        return false;
    }
    
    public boolean reorderedPowerOf2(int n) {
        if(n == 1) return true;
        int numOfDigits = 0;
        int temp = n;
        while(temp > 0){
            temp /= 10;
            numOfDigits++;
        }
        return checkValues(numOfDigits, getHash(n));
    }
}