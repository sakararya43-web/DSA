class Solution {
    class Pair{
        int row;
        int col;
        int obs;
        Pair(int row,int col,int obs)
        {
            this.row = row;
            this.col = col;
            this.obs = obs;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dist[][] = new int[n][m];
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.obs,b.obs));
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int curr_obs = p.obs;

            if (curr_obs > dist[row][col]) continue;

            if(row == n-1 && col == m-1) return curr_obs;
            for(int i=0;i<4;i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {                                       
                    int new_obs = curr_obs + grid[nrow][ncol] ;

                    if(new_obs < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = new_obs;
                        pq.add(new Pair(nrow,ncol,dist[nrow][ncol]));
                    }
                }
            }
        }
        return 0;
    }
}