class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long)Math.sqrt(c);

        while(low<=high)
        {
            long result = (low*low)+high*high;
            if(result==c) return true;

            else if(result<c)
            {
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}