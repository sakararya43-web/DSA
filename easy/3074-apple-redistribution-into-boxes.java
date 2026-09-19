class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int c=0;
        int min_count=0;
        int sum=0;
        int n=capacity.length;
        for(int i=0;i<apple.length;i++)
        {
            sum+=apple[i];
        }
        Arrays.sort(capacity);
        for(int i=n-1;i>=0;i--)
        {
            if(c<sum)
            {
                c+=capacity[i];
                min_count++;
                
            }
        }
        return min_count;
    }
}