class Solution {
    class disjoint{
        int[] rank;
        int[] parent;
        disjoint(int n)
        {
            rank = new int[n];
            parent = new int[n];

            for(int i = 0;i<n;i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x)
        {
            if(parent[x] == x) return x;

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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        disjoint dis = new disjoint(n+1);
        int [] arr = new int[2];
        for(int []edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            if(dis.find(u)==dis.find(v))
            {
                arr[0] = u;
                arr[1] = v;
            }
            else{
                dis.union(u,v);
            }
        }
        return arr;
        
    }
}