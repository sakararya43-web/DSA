class Solution {
    class disjoint{
        int [] parent;
        int [] size;
        disjoint(int n)
        {
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x)
        {
            if(parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }
        void union_size(int u,int v)
        {
            int pu = find(u);
            int pv = find(v);

            if(pu==pv) return;

            if(size[pu] < size[pv])
            {
                parent[pu] = pv;
                size[pv]+=size[pu];
            }
            else{
                parent[pv] = pu;
                size[pu]+=size[pv];
            }
        }
    }
    public int largestIsland(int[][] grid) {
       int n = grid.length;
       disjoint dis = new disjoint(n*n);
       for(int row=0;row<n;row++)
       {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==0) continue;
                int [] delrow = {-1,0,1,0};
                int [] delcol = {0,1,0,-1};
                for(int i=0;i<4;i++)
                {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1)
                    {
                        int node_no = row * n + col;
                        int adjnode_no = nrow * n+ ncol;
                        dis.union_size(node_no,adjnode_no);
                    }
                }
            }
       }
       int maxlen = 0;
       for(int row = 0;row<n;row++)
       {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==1) continue;
                int [] delrow = {-1,0,1,0};
                int [] delcol = {0,1,0,-1};
                HashSet<Integer> set = new HashSet<>();
                for(int i=0;i<4;i++)
                {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n)
                    {
                        if(grid[nrow][ncol]==1)
                        {
                            set.add(dis.find(nrow * n + ncol));
                        }
                    }
                }
                int ttl_size = 0;
                for(int parent:set)
                {
                    ttl_size+=dis.size[parent];
                }
                maxlen = Math.max(maxlen,ttl_size+1);
            } 
       }
       for(int cellno=0;cellno < n*n;cellno++)
       {
            maxlen = Math.max(maxlen,dis.size[dis.find(cellno)]);
       }
       return maxlen;


    }
}