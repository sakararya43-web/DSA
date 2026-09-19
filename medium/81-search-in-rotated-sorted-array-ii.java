class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0,right=nums.length-1;

        while(left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]==target) return true;

            else if(target>nums[mid]) left=mid+1;

            else{
                right=mid-1;
            }
        }
        return false;
    }
}