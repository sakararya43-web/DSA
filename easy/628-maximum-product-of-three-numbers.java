class Solution {
    public int maximumProduct(int[] nums) {  
        int i=0;
        int n=nums.length;
        int j=n-1;
       
        Arrays.sort(nums);
        

        int prod1=nums[0] * nums[1] * nums[n-1];
        int prod2=nums[n-1] * nums[n-2] * nums[n-3];
    return Math.max(prod1,prod2);
        
    }
}