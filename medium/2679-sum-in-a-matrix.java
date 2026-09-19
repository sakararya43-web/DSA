class Solution {
    public int matrixSum(int[][] nums) {
        
        int n = nums.length;
        int m = nums[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int score = 0;
        for(int i=0;i<n;i++)
        {
            Arrays.sort(nums[i]);

        }
        int j=m-1;
        while(j>=0)
        {
            for(int i=0;i<n;i++)
            {
                pq.add(nums[i][j]);
            }
            j--;
            score+=pq.poll();

            pq.clear();
        }
        return score;
        
    }
}