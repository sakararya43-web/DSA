class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long temp=0;
        while(n>0)
        {
            int a = n%10;
            if(a!=0)
            {   sum+=a;
                temp = temp*10 +a;
            }
            n=n/10;

        }
        long result = 0;
        while(temp>0)
        {
            
            result = result*10+(temp%10);
            temp=temp/10;
        }
        return result * sum;

    }
}