class Solution {
    public int halveArray(int[] nums) {
       PriorityQueue<Number> pq = new PriorityQueue<>((a, b) -> Double.compare(b.doubleValue(), a.doubleValue()));

       long sum = Arrays.stream(nums).asLongStream().sum();

       double half = (double)sum/2;

       int ops = 0;
       double cnt_sum=0;

       for (int i=0;i<nums.length;i++)
       {
            pq.add(nums[i]); 
       } 
       while(cnt_sum < half)
       {
            double temp  = pq.poll().doubleValue();
            double reduced = temp/2;
            pq.add(reduced);
            cnt_sum+=reduced;
            ops++;

       }
       return ops;
    }
}