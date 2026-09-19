class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {   int c=0;
            int min=nums[i];
            for(int j=0;j<nums.length;j++)
            {
                if(min>nums[j])
                {
                    c++;
                }
            }
            arr[i]=c;

        }
        return arr;
    }
}