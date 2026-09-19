class Solution {
    public int mySqrt(int x) {
       
        double a=Math.sqrt(x);
        double b=Math.floor(a);
        int c=(int) b;
        return c;
    }
}