class Solution {
    
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(long num:target)
        {
            pq.add(num);
            sum+=num;
        }
        
        while(pq.peek()!=1)
        {              
            long max_ele = pq.poll();
            long remsum = sum - max_ele;
            long element = max_ele - remsum;
            
            if(remsum<=0 || remsum>=max_ele) return false;

            element = max_ele % remsum;
            if(element==0)
            {
                if(remsum!=1) return false;
                else{
                    return true;
                }
            }   
            sum = element + remsum;
            pq.add(element);
        }
        return true;
    }
}