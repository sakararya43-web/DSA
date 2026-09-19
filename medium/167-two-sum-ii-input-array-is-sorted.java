class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] index = new int[2];
        int low=0,high=numbers.length-1;
        while(low<=high)
        {
            int mid=numbers[low]  + numbers[high];

            if(mid==target)
            {
                return new int[]{low+1,high+1};
            }
            else if(target<mid)
            {
                
                high--;
            }
            else{
                low++;
            }   
        }

        return new int[]{-1,-1};          
    }
}