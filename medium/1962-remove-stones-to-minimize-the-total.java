class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : piles)
        {
            pq.add(num);
        }
        while(k > 0)
        { 
            int temp = pq.poll();
            pq.add((temp+1)/2);
            k--;
        }
        int sum=0;
        while(!pq.isEmpty())
        {
            sum+=pq.poll();
        }
        return sum;
    }
}