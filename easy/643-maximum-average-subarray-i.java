class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg=-Double.MAX_VALUE;
        if(nums.length==1) return (double) nums[0];
        int l=0,r=0;
        int sum=0;
        double avg=0;
        for(r=0;r<nums.length;r++)
        {
            sum+=nums[r];
            if((r-l+1)==k)
            {
               avg= (double)sum/k;
               maxavg = Math.max(maxavg,avg);
               sum-=nums[l];
               l++;
            }
                      
        }
        return maxavg;
    }
}