class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        
        while(true && i<matrix.length)
        {   int low =0,high = matrix[0].length-1;
            
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(matrix[i][mid]==target) return true;

                else if(target < matrix[i][mid]) high=mid-1;

                else{
                    low=mid+1;
                }

            }
            i++;
        }
        return false; 
    }
}