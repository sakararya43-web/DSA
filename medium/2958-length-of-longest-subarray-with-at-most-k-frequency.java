class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int l =0;
        int maxlen = 0;
        for(int r=0;r<nums.length;r++)
        {
            if(map.containsKey(nums[r]))
            {
                map.put(nums[r],map.get(nums[r])+1);
            }
            else{
                map.put(nums[r],1);

            }
            while(map.get(nums[r]) > k) 
            {
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }    
            maxlen = Math.max(maxlen,r-l+1);
           
        }
        return maxlen;

    }
}