class Solution {
    private static int solve(int[] nums,int distinct)
    {
        int left =0;
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<nums.length;right++)
        {   
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            while(map.size() == distinct)
            {

                    ans += nums.length - right;
                    map.put(nums[left], map.get(nums[left])-1);

                    if(map.get(nums[left]) == 0)
                    { 
                        map.remove(nums[left]);
                    }

                left++;
            }
        }
        return ans;

    }
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int distinct = set.size();
        return solve(nums,distinct);
    }
}