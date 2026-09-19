class Solution {
    public int maxArea(int[] height) {
        int low = 0,high = height.length-1;
        int maxarea= 0;
        while(low<high)
        {
            int area = (Math.min(height[low],height[high])) * (high-low);
            maxarea = Math.max(maxarea,area);
            if(height[low]<height[high]) low++;
            else{
                high--;
            }
        }
        return maxarea;
        
    }
}