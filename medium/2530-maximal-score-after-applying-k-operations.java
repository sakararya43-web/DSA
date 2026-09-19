class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
    for(int num:nums)
    {
        pq.add(num);
    } 
    long score=0;
    while(k>0) 
    {
        int temp= pq.poll();
        int ceil= (int)Math.ceil((double)temp/3);
        
        score+=temp;
        pq.add(ceil);
        k--;
    }
    return score;
    }
}