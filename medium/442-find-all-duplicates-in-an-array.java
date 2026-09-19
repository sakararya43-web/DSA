class Solution {
    private static List<Integer> solve(int[] nums, List<Integer> ans)
    {   
        if(nums.length==1) return ans;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                ans.add(nums[i]);
            }
            else{
                map.put(nums[i],1);
            }
        }
        return ans;

    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return solve(nums,ans);
    }
}