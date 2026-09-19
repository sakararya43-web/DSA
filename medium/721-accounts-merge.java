class Solution {
    class disjoint{
        int parent[];
        int rank[];
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
            if(parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }

        void union(int u,int v)
        {
            int pu = find(u);
            int pv = find(v);

            if(pu==pv) return;

            else if(rank[pu] < rank[pv])
            {
                parent[pu] = pv;
            }
            else if(rank[pv] < rank[pu])
            {
                parent[pv] = pu;
            }
            else{
                parent[pv] =  pu;
                rank[pu]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String,Integer> map = new HashMap<>();
        disjoint dis = new disjoint(n);
        List<List<String>> list = new ArrayList<>();  
        
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail = accounts.get(i).get(j);

                if(map.containsKey(mail))
                {
                    int prev_acc = map.get(mail);
                    dis.union(i,prev_acc);
                }
                else{
                    map.put(mail,i);
                }
            }
        }

        ArrayList<String>[] merging= new ArrayList[n];

        for(int i=0;i<n;i++)
        {
            merging[i] = new ArrayList<>();
        }

        for(String mail:map.keySet())
        {
            int root = dis.find(map.get(mail));
            merging[root].add(mail);
        }

        for(int i=0;i<n;i++)
        {
            if(merging[i].size()==0) continue;
           
            Collections.sort(merging[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merging[i]);
            list.add(temp);

        }
        return list;

    }
}