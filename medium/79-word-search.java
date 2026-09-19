class Solution {
    private boolean dfs(int row,int col,char[][] board,int[][] vis,int[] delrow,int[] delcol,int x,String word)
    {   
        if(x==word.length()) return true;
        
        vis[row][col]=1;
        int n = board.length;
        int m =board[0].length;
        int size=0;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]==word.charAt(x))
            {
                if(dfs(nrow,ncol,board,vis,delrow,delcol,x+1,word)) return true;
            }
        }
        vis[row][col]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];
        int [] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int x=0;
        for(int i = 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,board,vis,delrow,delcol,x+1,word)) return true;
                }
            }
        }
        return false;
    }
}