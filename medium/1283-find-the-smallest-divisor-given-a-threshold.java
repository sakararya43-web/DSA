class Solution {
    private static int getsum(int[] nums,int k)
    {   int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=Math.ceil((double)nums[i]/k);
        }
        return sum;
    }    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low =1,high= Arrays.stream(nums).max().getAsInt();
        int a=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int reqsum = getsum(nums,mid);
            if(reqsum <= threshold)
            {
                 a = mid;
                high = mid-1;
            }

            else if(reqsum>threshold)
            {
                low=mid+1;
            }
            
        }
        return a;   
    }
}