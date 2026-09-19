class Solution {
    int sum = 0;
    class Pair{
        int node;
        int time;
        Pair(int node,int time)
        {
            this.node = node;
            this.time = time;
        }
    }
    private void dfs(int node,List<List<Pair>> adjlist,int[] values,int maxTime,int[] vis,int curr_time,int curr_score)
    {
        if(vis[node]==0)
        {
            curr_score += values[node];
        }
        vis[node]++;
        if(node == 0)
        {
            sum = Math.max(sum,curr_score);
        }   
        for(Pair p : adjlist.get(node))
        {
            int adjnode = p.node;
            int adjtime = p.time;

            if(curr_time + adjtime <= maxTime)
            {
                dfs(adjnode,adjlist,values,maxTime,vis,curr_time + adjtime,curr_score);
                
            }
        }
        vis[node]--;
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        int m = edges.length;
        List<List<Pair>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjlist.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int time = edges[i][2];

            adjlist.get(u).add(new Pair(v,time));
            adjlist.get(v).add(new Pair(u,time));
        }
        int vis[] = new int[n];
        
        dfs(0,adjlist,values,maxTime,vis,0,0);
        
        return sum;
    }
}