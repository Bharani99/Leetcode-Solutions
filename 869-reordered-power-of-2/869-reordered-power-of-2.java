class Solution {
    public boolean checkAnagram(int num, int curr){
        int[] hash = new int[10];
        while(num > 0){
            hash[num % 10]++;
            num /= 10;
        }
        while(curr > 0){
            if(hash[curr % 10] == 0) return false;
            hash[curr % 10] --;
            curr /= 10;
        }
        return true;
    }
        
    public boolean checkValues(int digits, int num){
        int[] pattern = new int[]{0, 4, 7};
        int[] end = new int[]{4, 3, 3};
        int bucket = (digits - 1) / 3;
        int start = (digits - 1) % 3;
        int index = bucket * 10 + pattern[start];
        for(int i = 0; i < end[start]; i++){
            if(checkAnagram(1 << index++, num)) 
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
        return checkValues(numOfDigits, n);
    }
}