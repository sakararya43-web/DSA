class Solution {
    public int mirrorDistance(int n) {
        int t=n;
        int s=0;
        while(n>0)
        {
            int a= n%10;
            s=s*10 + a;
            n/=10;
        }
        return Math.abs(t-s);
    }
}