class Solution {
    class Pair{
        int row;
        int col;
        int health;
        Pair(int row,int col,int health)
        {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int maxhealth [][] = new int[grid.size()][grid.get(0).size()];
        int n = grid.size();
        int m= grid.get(0).size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.health-a.health);
        int [] delrow ={-1,0,1,0};
        int [] delcol ={0,1,0,-1}; 
        int start_health= health - grid.get(0).get(0);
        pq.add(new Pair(0,0,start_health));
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int curr_health = p.health;
            if(curr_health<=maxhealth[row][col]) continue;

            maxhealth[row][col] = curr_health;
            if(row==n-1 && col==m-1)
            {
                return true;              
            }
            for(int i=0;i<4;i++)
            {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {   
                    int newhealth = curr_health;
                    if(grid.get(nrow).get(ncol)==1)
                    {
                        newhealth--;
                    }
                    if(newhealth<=0) continue;

                    if(newhealth > maxhealth[nrow][ncol])
                    {                         
                        pq.add(new Pair(nrow,ncol,newhealth));
                    }

                    
                }
            }

        }
        return false;

    }
}