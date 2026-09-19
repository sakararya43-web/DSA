class Solution {
    class Pair{
        int row;
        int col;
        int step;
        Pair(int row,int col,int step)
        {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int [][] vis = new int[n][m];
        int [][] dist = new int[n][m];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair temp  = q.poll();
            int row = temp.row;
            int col = temp.col;
            int step = temp.step;

            dist[row][col] = step;

            for(int i = 0;i<4;i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( ncol>=0 && ncol < m && nrow>=0 && nrow < n && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow,ncol,step+1));
                }
            }

        }
        return dist;
    }
}