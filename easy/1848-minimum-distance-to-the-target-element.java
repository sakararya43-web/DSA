class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int a1=Integer.MAX_VALUE;
        int a2=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=start;i<n;i++)
        {
            if(nums[i]==target)
            {
                a1 = Math.abs(i-start);
                break;
            }
        }
        for(int j=start;j>=0;j--)
        {
            if(nums[j]==target)
            {
                a2 = Math.abs(j-start);
                break;
            }
        }
        return Math.min(a1,a2);
    }
}