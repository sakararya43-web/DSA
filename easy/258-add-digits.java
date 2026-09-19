class Solution {
    public int addDigits(int num) {
        int temp=0;
        int sum=0;
        while(num>0)
        {    while(num>0)
            {
                temp=num%10;
                sum+=temp;
                num/=10;
            }
            if(sum>9)
            {
                num=sum;
                sum=0;
            }
        }
        return sum;
    }
}