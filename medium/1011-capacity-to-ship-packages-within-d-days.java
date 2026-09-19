class Solution {
    private static int getdays(int[] weights , int cap)
    {
        int day=1,load =0;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i] > cap)
            {
                day++;
                load = weights[i]; 
            }
            else{
                load+=weights[i];
            }
        }
        return day;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt(); 
        int high=Arrays.stream(weights).sum();
        int a=0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int reqdays=getdays(weights,mid);

            if(reqdays<=days)
            {
                a=mid;
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return a;

    }
}