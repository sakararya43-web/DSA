class Solution {
    class Pair{
        int val;
        int row;
        int col;
        Pair(int val,int row,int col)
        {
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int max=Integer.MIN_VALUE;
        int [] arr = new int[2];
        for(int i=0;i<nums.size();i++)
        {
            pq.add(new Pair(nums.get(i).get(0),i,0));
            max=Math.max(max,nums.get(i).get(0));
        }
        int min = pq.peek().val;

        arr[0] = min;
        arr[1] = max;

        int ele=0,row=0,col=0; 
        while(pq.size()==nums.size())
        {
            Pair temp = pq.poll();
            ele = temp.val;
            row = temp.row;
            col = temp.col;

            if(col+1<nums.get(row).size())
            {
                col++;
                pq.add(new Pair(nums.get(row).get(col),row,col));
                max =Math.max(max,nums.get(row).get(col));
                min = pq.peek().val;
            }

            if(max-min < arr[1]-arr[0])
            {
                arr[0] = min;
                arr[1] = max;
            }

        }
        return arr;
        
    }
}