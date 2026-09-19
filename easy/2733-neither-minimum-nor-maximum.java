class Solution {
    public int findNonMinOrMax(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int a=0;
        int n=nums.length;
        if(n<=2) return -1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max) max =nums[i];

            if(nums[i]<min) min=nums[i];

            
        }
        for(int j=0;j<n;j++)
        {
            if(nums[j]<max && nums[j]>min) a=nums[j];
        }
        return a;
    }
}