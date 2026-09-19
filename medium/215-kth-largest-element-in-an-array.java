class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }

        int cnt=0;
        while(cnt!=k-1 && !pq.isEmpty())
        {
            int max = pq.peek();
            pq.poll();
            cnt++;
            
        }
        
        return pq.peek();
    }
}