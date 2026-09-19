class Solution {
    class Pair{
        int row;
        int col;
        int cost;
        Pair(int row,int col,int cost)
        {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int[] delrow = {0,0,1,-1};
        int[] delcol = {1,-1,0,0};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int curr_row = p.row;
            int curr_col = p.col;
            int curr_cost = p.cost;
        
            if(curr_row==n-1 && curr_col ==m-1)
            {
                return curr_cost;
            }

            for(int i=0;i<4;i++)
            {
                int nrow = curr_row + delrow[i];
                int ncol = curr_col + delcol[i];
                int cost = 0;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    if(grid[curr_row][curr_col] != i+1)
                    {
                        cost = 1;
                    }
                    int new_cost = curr_cost + cost;

                    if(new_cost < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = new_cost;
                        pq.add(new Pair(nrow,ncol,new_cost));
                    }
                }
            }

        }
        return -1;
    }
}