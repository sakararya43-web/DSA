class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,high =nums.length-1;
        int mid=0;
        int res=nums.length;
        while(low<=high)
        {   mid=(low+high)/2;

            if(nums[mid]==target) return mid;

            else if(nums[mid]>target)
            {
                high=mid-1;
                res=mid;
            }
            else{
                low=mid+1;
            }
        }
        return res;


    }
}