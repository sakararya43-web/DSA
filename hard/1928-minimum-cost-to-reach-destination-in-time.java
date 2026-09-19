class Solution {
    class tuple{
        int time;
        int node;
        int cost;
        tuple(int time,int node,int cost)
        {
            this.time = time;
            this.node = node;
            this.cost = cost;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<tuple>> adj = new ArrayList<>();
        int [][] dist = new int[n][maxTime + 1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = passingFees[0];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int time = edges[i][2];
            adj.get(u).add(new tuple(time,v,0));
            adj.get(v).add(new tuple(time,u,0));
        }
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new tuple(0,0,dist[0][0]));
        while(!pq.isEmpty())
        {   
            int i=0;
            tuple t = pq.poll();
            int curr_time = t.time;
            int curr_node = t.node;
            int curr_cost = t.cost;


            if(curr_node == n-1) return curr_cost;
            
            for(tuple p : adj.get(curr_node))
            {
                int adjnode = p.node;
                int adjtime = p.time;
                int adjcost = p.cost;

                int new_time = curr_time + adjtime;

                 if(new_time > maxTime) continue;
                    
                    int new_cost = curr_cost + passingFees[adjnode];
                    
                    if(new_cost < dist[adjnode][new_time])
                    {
                        dist[adjnode][new_time] = new_cost;
                        pq.add(new tuple(new_time,adjnode,new_cost));
                    }
                

            }
        }
        return -1;
    }
}