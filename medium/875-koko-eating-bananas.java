class Solution {
    private static int req(int[] piles,int k)
    {
        int total_time=0;
        for(int i=0;i<piles.length;i++)
        {   
            total_time+=Math.ceil((double)piles[i]/k);
        }
        return total_time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low=1,high = piles[piles.length-1];
        int reqtime=0;
        int a=0;
        while(low<=high)
        {
            int mid = (low+high)/2;

            reqtime=req(piles,mid);
            if(reqtime<=h)
            {
                a=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return a;
    }
}