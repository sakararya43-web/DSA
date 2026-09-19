class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int n = nums.length;
        int prefixmax[] = new int[n];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,nums[i]);
            prefixmax[i] = max;
        }
        int suffixmin[] = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            min = Math.min(min,nums[i]);
            suffixmin[i] = min;
        }

        for(int i=0;i<n;i++)
        {
            if((prefixmax[i]-suffixmin[i])<=k) return i;
        }
        return -1;
    }
}