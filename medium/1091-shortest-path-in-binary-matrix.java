class Solution {
    class Pair{
        int dist;
        int row;
        int col;
        Pair(int row,int col,int dist)
        {
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;

        int [][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        int [] delrow={-1, -1, -1, 0, 0, 1, 1, 1};
        int [] delcol={-1, 0, 1, -1, 1, -1, 0, 1};
        vis[0][0] = 1;
        q.add(new Pair(0,0,1));

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;

            if(row==n-1 && col==m-1) return dist;

            for(int i=0;i<8;i++)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,dist+1));
                }
            }
        }
        return -1;
    }
}