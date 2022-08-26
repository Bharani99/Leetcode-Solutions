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
        
    public boolean checkValues(int digits, int[] powers, String hash){
        int[] pattern = new int[]{0, 4, 7};
        int[] end = new int[]{4, 3, 3};
        int bucket = (digits - 1) / 3;
        int start = (digits - 1) % 3;
        int index = bucket * 10 + pattern[start];
        for(int i = 0; i < end[start]; i++){
            if(getHash(powers[index++]).equals(hash)) 
                return true;
        }
        return false;
    }
    
    public boolean reorderedPowerOf2(int n) {
        if(n == 1) return true;
        int[] powers = new int[31];
        int vals = 1;
        for(int i = 0; i < 31; i++){
            powers[i] = vals;
            vals *= 2;
        }
        int numOfDigits = 0;
        int temp = n;
        while(temp > 0){
            temp /= 10;
            numOfDigits++;
        }
        return checkValues(numOfDigits, powers, getHash(n));
    }
}