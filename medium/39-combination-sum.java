class Solution {
    private void solve(int idx,int[] candidates,int target,List<Integer> res,List<List<Integer>> ans)
    {
        if(target==0)
        {          
            ans.add(new ArrayList<>(res)); 
            return;
        }

        if(idx == candidates.length || target < 0) return;

        res.add(candidates[idx]);
        solve(idx,candidates,target-candidates[idx],res,ans);
        res.remove(res.size()-1);
        solve(idx+1,candidates,target,res,ans);
        

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<Integer> res = new ArrayList<>();
       List<List<Integer>> ans = new ArrayList<>();
       solve(0,candidates,target,res,ans);
       return ans;
    }
}