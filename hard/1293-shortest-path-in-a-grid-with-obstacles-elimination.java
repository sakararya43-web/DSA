class Solution {
    class Pair{
        int row;
        int col;
        int steps;
        int obs;
        Pair(int row,int col,int steps,int obs)
        {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.obs = obs;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int dist[][] = new int[n][m];
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0,0));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int curr_steps = p.steps; 
            int curr_obs = p.obs;  

            if(row == n-1 && col == m-1) return curr_steps;
            for(int i=0;i<4;i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    int new_obs = curr_obs + grid[nrow][ncol];

                    if(new_obs<=k && new_obs < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = new_obs;
                        q.add(new Pair(nrow,ncol,curr_steps+1,new_obs));
                    }        
                }
            } 
        }
        return -1;
    }
}