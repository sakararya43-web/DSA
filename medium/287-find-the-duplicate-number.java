class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n+1];
        for(int i=0;i<n;i++)
        {   
            int ele = nums[i];
            if(vis[ele]==true)
            {   
                return ele;
            }
            else{
                vis[ele] = true;
            }
        }
        return -1;
    }
}