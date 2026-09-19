class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    
    class tuple{
        int stop;
        int node;
        int dist;
        tuple(int stop,int node,int dist)
        {
            this.stop=stop;
            this.node = node;
            this.dist = dist;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        List<List<Pair>> adj = new ArrayList<>();
        int m = flights.length;

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());            
        }
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<tuple> q = new LinkedList<>();

        q.add(new tuple(0,src,0));
        dist[src] =  0;
        while(!q.isEmpty())
        {
            tuple t = q.poll();
            int stop = t.stop;
            int node = t.node;
            int currentDist = t.dist;

            if(stop > k) continue;

            for(Pair p:adj.get(node))
            {
                int adjnode = p.first;
                int edgewt = p.second;


                if(edgewt + currentDist < dist[adjnode] && stop<=k)
                {
                    dist[adjnode] = edgewt + currentDist;
                    q.add(new tuple(stop+1,adjnode,edgewt+currentDist));
                }
            }
        }
        if(dist[dst]==(int)(1e9)) return -1;

        return dist[dst];
    }
}