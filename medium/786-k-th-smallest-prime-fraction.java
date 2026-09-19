class Solution {
    class Pair{
        int val1;
        int val2;
        double div;
        Pair(int val1,int val2,double div)
        {
            this.val1 = val1;
            this.val2 = val2;
            this.div = div;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int  n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.div, b.div));
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                double div = (double) arr[i] / arr[j];
                pq.add(new Pair(arr[i],arr[j],div));

            }
        }
        for(int i=0;i<k-1;i++)
        {
            pq.poll();
        }
        Pair ele = pq.peek();
       
       return new int[]{ele.val1,ele.val2};
    }
}