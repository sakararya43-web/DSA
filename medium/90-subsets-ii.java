class Solution {
    private void solve(int idx,int[] nums,Set<List<Integer>> ans,List<Integer> res)
    {
        if(idx == nums.length)
        {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(idx>=nums.length) return;

        res.add(nums[idx]);
        solve(idx+1,nums,ans,res);
        res.remove(res.size()-1);
        solve(idx+1,nums,ans,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        solve(0,nums,ans,res);
        return new ArrayList<>(ans);
    }
}