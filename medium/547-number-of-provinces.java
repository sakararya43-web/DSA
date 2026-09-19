class Solution {
    class disjoint{
        int rank[];
        int parent[];
        disjoint(int n)
        {
            rank = new int [n];
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

            if(rank[pu] < rank[pv])
            {
                parent[pu] = pv;
            }
            else if(rank[pv] < rank[pu])
            {
                parent[pv] = pu;
            }
            else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;

        disjoint dis = new disjoint(n);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    dis.union(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            if(dis.find(i)==i)
            {
                cnt++;
            }
        }
        return cnt;
    }
}