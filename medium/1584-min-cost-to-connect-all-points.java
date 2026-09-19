class Solution {
    class Pair{
        int cost;
        int node;
        Pair(int cost,int node)
        {
            this.cost = cost;
            this.node = node;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int vis[] = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(0,0));
        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty() && cnt<n)
        {
            Pair p = pq.poll();
            int curr_cost = p.cost;
            int curr_node = p.node;

            if(vis[curr_node]==1) continue;
           
            vis[curr_node] = 1;
            sum+=curr_cost;
            cnt++;
            
            for(int adjnode =0;adjnode<n;adjnode++)
            {
                if(vis[adjnode]==0)
                {
                    int new_cost = Math.abs(points[curr_node][0] - points[adjnode][0]) + Math.abs(points[curr_node][1] - points[adjnode][1]);

                    pq.add(new Pair(new_cost,adjnode));
                }
            } 
        }
        return sum;
    }
}