class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if (!(s1+s2).equals(s2+s1))  return "";

        int gcdVal = gcd(s1.length() , s2.length());
        return s2.substring(0, gcdVal);
    }

    public int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
}