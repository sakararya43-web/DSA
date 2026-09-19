class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjrev = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i < n;i++)
        {
            adjrev.add(new ArrayList<>());
        
        }
        int indegree[] = new int[n];
        for (int i = 0;i < n;i++)
        {
            for (int it:graph[i]) 
            {
                adjrev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp = q.poll();
            ans.add(temp);
            for(int it:adjrev.get(temp))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}