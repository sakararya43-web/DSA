class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for( int num: nums)
        {
            pq.add((long)num);
        }
        int ops = 0;
        while(pq.peek() < k)
        {   
            long f_min = pq.poll();
            long s_min = pq.poll();

            long result = f_min * 2 + s_min;

            pq.add(result);
            ops++;
        }
        return ops;
    }
}