class Solution {
    private int f(int[][] obstacleGrid,int[][] dp,int i,int j)
    {
        if(i<0 || j<0) return 0;
        
        if(obstacleGrid[i][j] == 1) return 0;
        
        if(i==0 && j==0)
        {
            return 1;
        }    
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(obstacleGrid,dp,i-1,j);
        int left = f(obstacleGrid,dp,i,j-1);
        
        return dp[i][j] = up + left; 

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(obstacleGrid,dp,n-1,m-1);
    }
}