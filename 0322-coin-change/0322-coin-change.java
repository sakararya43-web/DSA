class Solution {
    private int f(int indx,int[] coins,int amount,int[][] dp)
    {
        if(indx==0)
        {
            if(amount % coins[indx]==0)
            {
                return amount/coins[0];
            }
            return (int)1e9;
        }
        if(dp[indx][amount]!=-1) return dp[indx][amount];
        
        int notake = 0 + f(indx-1,coins,amount,dp);
        int take = (int)1e9;
           if(amount>=coins[indx])
            {
                take = 1 + f(indx,coins,amount-coins[indx],dp);
            }
        
        return dp[indx][amount]=Math.min(take,notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int res = f(n-1,coins,amount,dp);

       return res>= (int)1e9?-1:res;
    
    }
}