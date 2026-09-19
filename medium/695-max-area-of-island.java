class Solution {
    int max = 0;
    private int dfs(int row,int col,int[][] grid,int[][] vis,int[] delrow,int[] delcol)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        int size=1;
        for(int i=0;i<4;i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {   
                size+=dfs(nrow,ncol,grid,vis,delrow,delcol);
            }
        }
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int max=0;
        int [][] vis = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {   
                    int size =dfs(i,j,grid,vis,delrow,delcol);
                    max = Math.max(size,max);
                }
            }

        }
        return max;
    }
}