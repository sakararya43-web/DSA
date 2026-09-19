class Solution {
    Boolean[] dp;
    private boolean f(int indx,int[] nums)
    {
        if(indx>=nums.length-1) return true;
        if(dp[indx] != null) return dp[indx];

        if(nums[indx]==0) return false;
        
        for(int i=1;i<=nums[indx];i++)
        {
            if(f(indx+i,nums)) return dp[i] = true;
           
        }
        return dp[indx] = false;

    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        return f(0,nums);
        
    }
}