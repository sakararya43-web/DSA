class Solution {
    private void dfs(int node,List<List<Integer>> adjlist,List<Integer> list,List<List<Integer>> ans,int n,int[][]graph)
    {
        if(node == n-1)
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(node > n) return;
        
        for(int adjnode : adjlist.get(node))
        {
            list.add(adjnode);
            dfs(adjnode,adjlist,list,ans,n,graph);

            list.remove(list.size()-1);
        
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int [] vis = new int[n];
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjlist.add(new ArrayList<>());
            for(int num : graph[i])
            {
                adjlist.get(i).add(num);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(0);
        dfs(0,adjlist,list,ans,n,graph);
        
        return ans;

    }
}