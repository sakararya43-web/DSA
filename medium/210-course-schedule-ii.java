class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = prerequisites.length;
        for(int i=0;i<numCourses;i++)
        {         
            adj.add(new ArrayList<>());                                
        }
        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int [] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp = q.poll();
            topo.add(temp);

            for(int it:adj.get(temp))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        if(topo.size()!=numCourses) return new int[0];
        int [] arr = new int[topo.size()];
        int i=0;
        
        for(int num:topo)
        {
            arr[i] = num;
            i++;
        }
        return arr;
    }
}