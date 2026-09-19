class Solution {
    private void dfs(int row,int col,char[][] grid,int[][] vis,int[] delrow, int[] delcol)
    {
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<4;i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow< n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1')
            {
                dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        int[][] vis = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {   
                    count++;
                    dfs(i,j,grid,vis,delrow,delcol);
                }
            }
        }
        return count;
        
    }
}