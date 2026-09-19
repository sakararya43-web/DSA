class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] arr = new int[nums.length];
        int leftprod =1;
        for(int i=0;i<nums.length;i++)
        {
            arr[i] = leftprod;
            leftprod =leftprod*nums[i];
            
        }
        int rightprod =1;
        for(int i=nums.length-1;i>=0;i--)
        {
            arr[i] *=rightprod;
            rightprod=rightprod*nums[i];
        }
        return arr;
    }
}