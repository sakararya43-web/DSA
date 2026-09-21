class Solution {
    private boolean f(int indx,int[] nums,int[][] dp,int sum)
    {
        
        if(sum==0) return true;

        if(indx==0) return nums[0]==sum;

        if(dp[indx][sum]!=-1) return dp[indx][sum]==1;
        boolean notake = f(indx-1,nums,dp,sum);
        boolean take = false;
        
        if(sum >=nums[indx])
        {
            take = f(indx-1,nums,dp,sum-nums[indx]);
        }
        dp[indx][sum] = take || notake?1:0;
        return take || notake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int[][] dp = new int[n][sum/2+1];
        for(int i =0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,nums,dp,sum/2);
    }
}