class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i<j)
                {
                    int temp1=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp1;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {   
            int p1=0,p2=n-1;
            while(p1<p2)
            {
                int temp=matrix[i][p1];
                matrix[i][p1]=matrix[i][p2];
                matrix[i][p2]=temp;
                p1++;
                p2--;
            }
        }
    }
}