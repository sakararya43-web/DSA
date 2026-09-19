class Solution {
    private static void solve(int[] nums,List<Integer> list,List<List<Integer>> ans)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        

        for(int i =0;i<nums.length;i++)
        {   if(list.contains(nums[i]))
            {
                continue;
            }
            list.add(nums[i]);
            solve(nums,list,ans);
            list.remove(list.size()-1);
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans  = new ArrayList<>();
        int n = nums.length;
        
        solve(nums,list,ans);
        return ans;
    }
}