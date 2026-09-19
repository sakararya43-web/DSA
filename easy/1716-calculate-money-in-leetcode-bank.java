class Solution {
    public int totalMoney(int n) {
        int i=0;
        int sum=0;
        int c=0;
        int counter=1;
            while(i<7 && c<n)
            {
                sum+=i + counter;
                c++;
                i++;                
                if(i==7)
                {
                    i=0;
                    counter++;
                }
            }
        
        return sum;
        
    }
}