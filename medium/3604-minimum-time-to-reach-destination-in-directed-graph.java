class Solution {
    class tuple{
        int start;
        int end;
        int node;
        
        tuple(int start,int end,int node)
        {
            this.start= start;
            this.end = end;
            this.node = node;
            
        }
    }
    class Pair{
        int time;
        int node;

        Pair(int time, int node) {
            this.time = time;
            this.node = node;
        }
    }
    public int minTime(int n, int[][] edges) {
        int [] dist = new int[n];
        int m = edges.length;
        List<List<tuple>> adj = new ArrayList<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {   
            int start = edges[i][2];
            int end = edges[i][3];
            int u =edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new tuple(start,end,v));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);

        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int curr_time = p.time;
            int curr_node = p.node;

            if (curr_node == n - 1) return curr_time;

            for(tuple t:adj.get(curr_node))
            {
                int adjnode = t.node;
                int adjstart = t.start;
                int adjend =  t.end;

                int newtime = Math.max(curr_time,adjstart);
                if(newtime <= adjend)
                {
                    newtime++;
                    if(newtime<dist[adjnode])
                    {
                        dist[adjnode]  = newtime;
                        pq.add(new Pair(dist[adjnode],adjnode));
                    }
                }
            }
        }
        return -1;
        
    }
}