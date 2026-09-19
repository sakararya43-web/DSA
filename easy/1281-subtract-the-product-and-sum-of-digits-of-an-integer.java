class Solution {
    public int subtractProductAndSum(int n) {
        int prod=1;
        int sum=0;
        while(n>0)
        {
            int a=n%10;
            prod*=a;
            sum+=a;
            n/=10;
        }
        return prod-sum;
    }
}