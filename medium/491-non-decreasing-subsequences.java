class Solution {
    private void solve(int idx,int[] nums,Set<List<Integer>> ans,List<Integer> res)
    {
        if(idx == nums.length)
        {
            if(res.size()>=2)
            {
                for(int i = 1;i<res.size();i++)
                {
                    if(res.get(i)<res.get(i-1))
                    {
                        return;
                    }
                }
                ans.add(new ArrayList<>(res));
            }
            return;
        }

        if(idx>=nums.length) return;

        res.add(nums[idx]);

        solve(idx+1,nums,ans,res);

        res.remove(res.size()-1);

        solve(idx+1,nums,ans,res);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> res = new ArrayList<>();
    
        solve(0,nums,ans,res);
        return new ArrayList<>(ans);
    }
}