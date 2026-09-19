class Solution {
    private static int findcount(int []nums,int goal)
    {
        int count = 0;
        int l=0,r=0;
        int sum=0;
        if(goal<0) return 0;
        while(r<nums.length)
        {

            sum += nums[r];
            

            while(sum>goal)
            {
                sum=sum-nums[l];
                l++;
            }
            count = count+ (r-l+1);

            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findcount(nums,goal)-findcount(nums,goal-1);
    }
        
}