class Solution {
    private void dfs(int row,int col,int[][] vis,char board[][],int[] delrow, int[] delcol)
    {
        int n = board.length;
        int m = board[0].length;

        vis[row][col] = 1;
        for(int i=0;i<4;i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>= 0 && nrow< n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='X')
            {
                dfs(nrow,ncol,vis,board,delrow,delcol);
            }
        }

    }
    public int countBattleships(char[][] board) {
        int n= board.length;
        int m = board[0].length;
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int max=0;
        int [][] vis = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X' && vis[i][j]==0)
                {
                    max++;
                    dfs(i,j,vis,board,delrow,delcol);
                }
            }
        }
        return max;
    }
}