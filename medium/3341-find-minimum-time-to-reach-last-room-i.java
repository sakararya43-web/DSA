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
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int [][] dist = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int curr_time = p.time;

            if(row==n-1 && col== m-1) return curr_time;
            for(int i=0;i<4;i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                int newTime = curr_time;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    if(curr_time < moveTime[nrow][ncol])
                    {
                        newTime +=Math.abs(moveTime[nrow][ncol] - newTime) + 1;
                        
                    }
                    else{
                        newTime++;
                        
                    }

                    if(newTime<dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = newTime;
                        pq.add(new Pair(newTime,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}