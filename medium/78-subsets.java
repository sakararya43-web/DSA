class Solution {
    private static void solve(int [] nums,List<Integer> list,List<List<Integer>> ans,int indx)
    {
        if(indx == nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[indx]);
        solve(nums,list,ans,indx+1);
        list.remove(list.size()-1);
        solve(nums,list,ans,indx+1);

    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list= new ArrayList<>();   
        solve(nums,list,ans,0);
        return ans;
    }
}