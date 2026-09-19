class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        final long MOD = 1_000_000_007L;
        for(int num:nums)
        {
            pq.add(num);
        }
        while(k>0)
        {
            int temp = pq.peek();
            pq.poll();
            temp+=1;
            pq.add(temp);
            k--;

        }
        long prod=1;
        for(int num:pq)
        {
            prod=(prod*num)%MOD;
        }
        return (int)prod;
    }
}