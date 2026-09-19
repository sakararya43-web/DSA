class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length==1) return 0;
        int j=0;
        int gap = 0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            gap = Math.max(gap,nums[i]-nums[j]);
            j++;
        }
        return gap;
       
    }
}