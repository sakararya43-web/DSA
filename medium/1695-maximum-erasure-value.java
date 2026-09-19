class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxsum=0;
        HashSet<Integer> set = new HashSet<>();
        int l=0,r=0;
        int currsum=0;
        for(r=0;r<nums.length;r++)
        {
            while(set.contains(nums[r]))
            {
                set.remove(nums[l]);
                currsum-=nums[l];
                l++;
                
            }
            
            set.add(nums[r]);                         
            currsum+=nums[r];
            maxsum=Math.max(currsum,maxsum);
           
        }
        return maxsum;
    }
}