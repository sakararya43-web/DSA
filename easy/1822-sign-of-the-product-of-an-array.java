class Solution {
    public int arraySign(int[] nums) {
        int negcount=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
                negcount+=1;
            }
            else if(nums[i]==0) return 0;     
        }
        if(negcount%2==0) return 1;

        else return -1;

    }
}