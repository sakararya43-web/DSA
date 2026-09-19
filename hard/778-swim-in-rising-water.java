class Solution {
    class Pair{
        int time;
        int row;
        int col;
        Pair(int time,int row,int col)
        {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));

        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int [] delrow ={-1,0,1,0};
        int [] delcol ={0,1,0,-1};
        pq.add(new Pair(grid[0][0],0,0));
        dist[0][0] = grid[0][0];
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int curr_time = p.time;
            int curr_row = p.row;
            int curr_col = p.col;

            if(curr_time > dist[curr_row][curr_col]) continue;

            if(curr_row == n-1 && curr_col == n-1) return curr_time;

            for(int i=0;i<4;i++)
            {
                int nrow = curr_row + delrow[i];
                int ncol = curr_col + delcol[i];

                if(nrow>=0 && nrow<n && ncol >= 0 && ncol<n)
                {
                    int new_time = Math.max(curr_time,grid[nrow][ncol]);

                    if(new_time < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = new_time;
                        pq.add(new Pair(new_time,nrow,ncol));                        
                    }
                }
                    
                
            }
        }
        return -1;
    }
}