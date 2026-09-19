class Solution {
    public int sumBase(int n, int k) {
       int s=0;
       while(n/k>0)
       {
        int a=n%k;
        s+=a;
        n=n/k;
       }
       s=s+(n%k);
       return s;
    }
}