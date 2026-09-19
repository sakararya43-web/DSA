class Solution {
    private boolean check(int start,int n,int[] color,List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty())
        {
            int temp = q.poll();

            for(int it:adj.get(temp))
            {
                if(color[it]==-1)
                {
                    color[it] = 1-color[temp];
                    q.add(it);
                }
                else if(color[it]==color[temp])
                {
                    return false;
                }

                
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            color[i]=-1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {   
            adj.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        for(int i=0;i<graph.length;i++)
        {           
            if(color[i]==-1)
            {
                if(check(i,graph.length,color,adj)==false)
                {
                    return false;
                }
            }
        }
        return true;
        


    }
}