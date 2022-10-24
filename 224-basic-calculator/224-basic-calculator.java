class Solution {
    int i = 0;
    
    public int doOperation(int val1, int val2, int op){
        return op == 0 ? val1 + val2 : val1 - val2;
    }
    public int calculate(String s) {
        int num = 0, op = 0;
        while(i < s.length()){
            char c = s.charAt(i++);
            if(c == '('){
                num = doOperation(num, calculate(s), op);
            }
            else if(c == ')') return num;
            else if(c == '+') op = 0;
            else if(c == '-') op = 1;
            else if(c == ' ') continue;
            else{
                int val = Character.getNumericValue(c);
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    val = (val * 10) + (s.charAt(i++) - '0');
                num = doOperation(num, val, op);
            }
        }
        return num;
    }
}