class Solution {
    private long dfs(int row,int col,int[][] vis,int[][]grid,int[]delrow,int[]delcol)
    {
        int n = grid.length;
        int m= grid[0].length;
        vis[row][col] = 1;
        long size = grid[row][col];
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow < n && ncol>=0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]>0)
            {
                size+=dfs(nrow,ncol,vis,grid,delrow,delcol);
            } 
        }
        return size;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int cnt=0;
        int delrow [] = {-1,0,1,0};
        int delcol [] = {0,1,0,-1};
        long size=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]>0)
                {
                    size=dfs(i,j,vis,grid,delrow,delcol);
                    if(size % k==0) cnt++;
                }

            }
        }
        return cnt;
    }
}