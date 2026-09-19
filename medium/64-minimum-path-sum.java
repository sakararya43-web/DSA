class Solution {
    private int f(int[][] grid,int[][] dp,int i,int j)
    {
        if(i<0 || j<0) return Integer.MAX_VALUE;
        
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j]!=-1) return dp[i][j];

        int up = f(grid,dp,i-1,j);
        int left = f(grid,dp,i,j-1);

        int path = Math.min(left,up);
        return dp[i][j] = path + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(grid,dp,n-1,m-1);
    }
}