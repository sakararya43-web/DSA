class Solution {
    private void dfs(int[] delrow,int [] delcol,int color,int row,int col,int [][] ans,int [][] image,int initial)
    {
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++)
        {
            int nrow  = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initial && image[nrow][ncol]!=color)
            {
                dfs(delrow,delcol,color,nrow,ncol,ans,image,initial);
            }

        }

    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial  = image[sr][sc];
        int[][] ans = image;
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        
        dfs(delrow,delcol,color,sr,sc,ans,image,initial);
        return ans;

    }
}