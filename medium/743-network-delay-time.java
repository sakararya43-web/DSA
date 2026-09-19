class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second=second;

        }
    }
    class tuple{
        int time;
        int node;
        tuple(int time,int node)
        {
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;
        List<List<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist,(int)(1e9));
        dist[k]=0;
        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new tuple(0,k));
        while(!pq.isEmpty())
        {
            tuple t = pq.poll();
            int curr_time = t.time;
            int curr_node = t.node;

            for(Pair p:adj.get(curr_node))
            {
                int adjnode = p.first;
                int adjtime = p.second;
                if(curr_time + adjtime < dist[adjnode])
                {
                    dist[adjnode] = curr_time + adjtime;
                    pq.add(new tuple(dist[adjnode],adjnode));
                }
            }  
        }
        int maxtime = 0;
        for(int i=1;i<=n;i++)
        {
            if(dist[i]==(int)(1e9)) return -1;

            maxtime = Math.max(maxtime,dist[i]);
        }
        return maxtime;
    }
}