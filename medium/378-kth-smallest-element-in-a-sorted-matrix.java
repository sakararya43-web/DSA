class Solution {
    class Pair{
        int val;
        int row;
        int col;

        Pair(int val,int row,int col)
        {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        int n = matrix.length;
        int ans=0;
        for(int i = 0;i<n;i++)
        {
            pq.add(new Pair(matrix[i][0],i,0));
        }

        while(k>0)
        {
            Pair Element = pq.peek();
            pq.poll();
            ans = Element.val;
            int row = Element.row;
            int col = Element.col;

            if(col+1<n)
            {
                pq.add(new Pair(matrix[row][col+1],row,col+1));
            }
            k--;
        }
        return ans;

    }
}