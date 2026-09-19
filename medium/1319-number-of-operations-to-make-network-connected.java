class Solution {
    class disjoint{
        int[] rank;
        int[] parent;
        disjoint(int n)
        {
            rank = new int[n];
            parent = new int[n];
            
            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
        } 

        int find(int x)
        {
            if(parent[x]==x) return x;

            return parent[x] = find(parent[x]);
        }


        void union(int u,int v)
        {
            int pu = find(u);
            int pv = find(v);
            
            if(pu==pv) return;

            else if(rank[pu]<rank[pv])
            {
                parent[pu] = pv;
            }

            else if(rank[pv]<rank[pu])
            {
                parent[pv] = pu;
            }
            else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        
        disjoint dis = new disjoint(n);
        int extraedges = 0;
        for(int i=0;i<connections.length;i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
                
            if(dis.find(u)==dis.find(v))
            {
                extraedges++;
            } 
            else{
                dis.union(u,v);
            }          
        }
        int nc = 0;
        for(int i=0;i<n;i++)
        {
            if(dis.parent[i]==i) nc++;
        }
        int ans = nc-1;
        if(extraedges>=ans) return ans;

        return -1;

    }
}