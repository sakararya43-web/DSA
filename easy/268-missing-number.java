class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int unreal=0;
        int real=0;
        for(int i= 0;i<=n;i++)
        {
            unreal+=i;
        }
        for(int j=0;j<n;j++)
        {
            real+=nums[j];
        }
        return unreal - real;
    }
}