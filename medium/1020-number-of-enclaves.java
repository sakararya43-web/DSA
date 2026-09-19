class Solution {
    private void dfs(int row,int col,int[][] grid,int [][]vis,int[] delrow,int[] delcol)
    {   
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>= 0 && nrow < n && ncol>=0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int[][] vis = new int[n][m];
        
        //1st n last row.
        for(int j=0;j<m;j++)
        {
            if(grid[0][j] == 1 && vis[0][j]==0)
            {
                dfs(0,j,grid,vis,delrow,delcol);
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==0)
            {
                dfs(n-1,j,grid,vis,delrow,delcol);
            }
        }
        //1st n last col.
        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1 && vis[i][0]==0)
            {
                dfs(i,0,grid,vis,delrow,delcol);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0)
            {
                dfs(i,m-1,grid,vis,delrow,delcol);
            }
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    c++;
                }
            }
        }
        
        return c;

    }
}