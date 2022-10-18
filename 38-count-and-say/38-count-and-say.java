class Solution {
    public String count(String num){
        StringBuilder sb = new StringBuilder();
        char prev = '#';
        int count = 0;
        for(char c : num.toCharArray()){
            if(c == prev) count++;
            else{
                if(count > 0){
                    sb.append(count + "" + prev);
                }
                count = 1;
                prev = c;
            }
        }
        if(count > 0){
            sb.append(count + "" + prev);
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        String proc = "1";
        while(n > 1){
            proc = count(proc);
            n--;
        }
        return proc;
    }
}