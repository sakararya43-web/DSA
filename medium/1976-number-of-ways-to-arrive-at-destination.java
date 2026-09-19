class Solution {
    class Pair{
        long dist;
        int node;
        Pair(long dist,int node)
        {
            this.dist = dist;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        long MOD = 1000000007;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            int edge = roads[i][2];
            adj.get(u).add(new Pair(edge,v));
            adj.get(v).add(new Pair(edge,u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        long [] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;
        long [] ways= new long[n];
        ways[0] = 1;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            long curr_dist = p.dist;
            int curr_node = p.node;
            for(Pair t:adj.get(curr_node))
            {   
                int adjnode = t.node;
                long edgewt = t.dist;

                if(curr_dist + edgewt < dis[adjnode])
                {
                    dis[adjnode] = curr_dist + edgewt;
                    pq.add(new Pair(dis[adjnode],adjnode));
                    ways[adjnode] = ways[curr_node] % MOD;
                }
                else if(curr_dist + edgewt == dis[adjnode])
                {

                    ways[adjnode] =(ways[adjnode] + ways[curr_node]) % MOD;
                }
                
            }
        }
        return (int)ways[n-1];

    }
}