class Solution {
    long maxstr=Integer.MIN_VALUE;
    private void solve(int idx,int nums[],List<Integer>ans)
    {
        if(idx == nums.length)
        {
            if(ans.size()>0)
            {
                long str =1;
                for(int it : ans)
                {
                str = (long)(str * it);
                }
                maxstr =(long) Math.max(maxstr,str);
                
            }
            return;
        }

        ans.add(nums[idx]);

        solve(idx+1,nums,ans);

        ans.remove(ans.size()-1);

        solve(idx+1,nums,ans);
    }
    public long maxStrength(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        solve(0,nums,ans);

        return maxstr;
    }
}