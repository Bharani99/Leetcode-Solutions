class Solution {
    int ans;
    public String getBinaryString(int val){
        String binary = Integer.toBinaryString(val);
        StringBuilder bstring = new StringBuilder();
        while(bstring.length() + binary.length() < 8) bstring.append("0");
        bstring.append(binary);
        return bstring.toString();
    }
    
    public int isParent(int val){
        String bstring = getBinaryString(val);
        ans = 0;
        for(char c : bstring.toCharArray()){
            if(c == '0') return ans;
            else ans++;
        }
        return ans;
    }
    
    public boolean isChild(int val){
        String bstring = getBinaryString(val);
        return bstring.charAt(0) == '1' && bstring.charAt(1) == '0';
    }
    
    public boolean validUtf8(int[] data) {
        boolean shouldBeParent = true;
        int n = 0;
        for(int i = 0; i < data.length; i++){
            if(shouldBeParent){
                n = isParent(data[i]);
                if(n == 1 || n > 4) return false;
                shouldBeParent = false;
            }

            else if(!isChild(data[i])) return false;
            
            n--;
            
            if(n < 1) shouldBeParent = true;
        }
        return shouldBeParent;
    }
}