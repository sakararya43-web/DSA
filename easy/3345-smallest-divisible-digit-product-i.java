class Solution {
    public int smallestNumber(int n, int t) {
        
        int b=0;
        while(true)
        {   int prod =1;
            b=n;
            while(b>0)
            {
                int a = b % 10;
                prod *= a;
                b/=10;

                 
            }
            if(prod % t==0) break;
            
            else{
               n++; 
            }    
        }
        return n;
    }
}