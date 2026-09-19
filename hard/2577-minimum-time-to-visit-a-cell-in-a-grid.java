class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time)
        {
            this.row = row;
            this.col= col;
            this.time = time;
        }
    }
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int dist[][] = new int[n][m];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        if(n > 1 && m > 1 && grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int curr_row = p.row;
            int curr_col = p.col;
            int curr_time = p.time;
            
            if(curr_time > dist[curr_row][curr_col]) continue;

            if(curr_row == n-1 && curr_col == m-1) return curr_time;

            for(int i=0;i<4;i++)
            {
                int nrow = curr_row + delrow[i];
                int ncol = curr_col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    int new_time = curr_time + 1;

                    if(new_time < grid[nrow][ncol])
                    {
                        int diff = grid[nrow][ncol] - curr_time;

                        if(diff % 2 == 0)
                        {
                            new_time = grid[nrow][ncol] + 1;
                        } 
                        else 
                        {
                            new_time = grid[nrow][ncol];
                        }
                    }
                    if(new_time < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = new_time;
                        pq.add(new Pair(nrow,ncol,dist[nrow][ncol]));
                    } 
                }
            }
        }
        return -1;
    }
}