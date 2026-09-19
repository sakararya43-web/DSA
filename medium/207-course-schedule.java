class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        int count=0;
        while(!q.isEmpty())
        {
            int temp = q.poll();
            count++;

            for(int it:adj.get(temp))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        if(count==numCourses) return true;
        return false;
    }
}