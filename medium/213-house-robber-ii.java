class Solution {
    private int solve2(int[] nums,int indx,int[] dp)
    {
        if(indx < 1) return 0;
        if(dp[indx]!=-1) return dp[indx];
        
        int pick = nums[indx] + solve2(nums,indx-2,dp); 
        int notpick = 0 + solve2(nums,indx-1,dp);
        
        return dp[indx]=Math.max(pick,notpick);
    }
    private int solve1(int[] nums,int indx,int[] dp)
    {
        if(indx==0) return nums[indx];
        if(indx < 0) return 0;
        if(dp[indx]!=-1) return dp[indx];
        
        int pick = nums[indx] + solve1(nums,indx-2,dp); 
        int notpick = 0 + solve1(nums,indx-1,dp);
        
        return dp[indx]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
       
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i] = -1;
        }
        int a=solve1(nums,n-2,dp);
        for(int i=0;i<n;i++)
        {
            dp[i] = -1;
        }
        int b = solve2(nums,n-1,dp);

        return Math.max(a,b);
    }
}