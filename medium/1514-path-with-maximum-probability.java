class Solution {
    class Pair{
        double prob;
        int node;
        Pair(double prob,int node)
        {
            this.prob = prob;
            this.node = node;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int m = edges.length;
        double dist[] = new double[n];
        Arrays.fill(dist,0.0);
        dist[start_node] = 1.0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(prob,v));
            adj.get(v).add(new Pair(prob,u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        pq.add(new Pair(1.0,start_node));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            double curr_prob = p.prob;
            int curr_node = p.node;

            if (curr_node == end_node) return curr_prob;
            for(Pair t : adj.get(curr_node))
            {
                double adjprob = t.prob;
                int adjnode = t.node;
                if(curr_prob * adjprob > dist[adjnode])
                {
                    dist[adjnode] = curr_prob * adjprob;
                    pq.add(new Pair(dist[adjnode],adjnode));
                }

            }
        }
        return 0.0;
    }
}