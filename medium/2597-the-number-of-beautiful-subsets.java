class Solution {
    int c=0;
    private void solve(int idx,List<Integer> list,int[] nums,int k)
    {
        if(idx == nums.length)
        {
            c++;
            return;
        }
       
        boolean add = true;
        for(int num : list)
        {
            if(Math.abs(num - nums[idx])==k)
            {
                add = false;
                break;
            }
        }
       if(add)
       {
            list.add(nums[idx]);
            solve(idx+1,list,nums,k);
            list.remove(list.size()-1);
       }
        solve(idx+1,list,nums,k);
    } 
    public int beautifulSubsets(int[] nums, int k) {
        if(nums.length==1) return 1;
        
        List<Integer> list = new ArrayList<>();
        solve(0,list,nums,k);
        return c-1;
    }
}