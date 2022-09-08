class Solution {
    public int maxDiff(int num) {
        int maximiseDigit = 1, minimiseDigit = -1;
        List<Integer> digits = new LinkedList<>();
        int temp = num, tens;
        boolean isFirst = true;
        while(temp > 0){
            digits.add(0, temp % 10);
            temp /= 10;
        }
        
        if(digits.get(0) == 1) {
            int i = 1;
            while(i < digits.size() - 1 && digits.get(i) < 2) i++;
            minimiseDigit = digits.get(i);
            isFirst = false;
        }
        else minimiseDigit = digits.get(0);
        
        int i = 0;
        while(i < digits.size() - 1 && digits.get(i) == 9) i++;
        maximiseDigit = digits.get(i);
        int a = 0, b = 0, curr;
        
        temp = num;
        tens = 1;
        while(temp > 0){
            curr = temp % 10;
            if(curr == minimiseDigit){
                a += ((isFirst) ? 1 : 0) * tens;
            }
            else {
                a += curr * tens;
            }
            if(curr == maximiseDigit){
                b += 9 * tens;
            }
            else {
                b += curr * tens;
            }
            temp /= 10;
            tens *= 10;
        }
        a = (a == 0) ? num : a;
        return b - a;
    }
}