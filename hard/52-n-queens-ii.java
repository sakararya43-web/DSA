class Solution {
    int count=0;
    private boolean isValid(char[][]queens,int row,int col,int n)
    {
        //upward
        for(int i=row-1;i>=0;i--)
        {
            if(queens[i][col]=='Q') return false;
        }

        //left diagonal
        for(int i=row-1,j = col-1;i>=0 && j>=0;i--,j--)
        {
            if(queens[i][j]=='Q') return false;
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
        {
            if(queens[i][j]=='Q') return false;
        }
        return true;
    }
    private void solve(char[][] queens,int row,int n)
    {
        if(row==n)
        {           
            count++;
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isValid(queens,row,col,n))
            {
                queens[row][col] = 'Q';

                solve(queens,row+1,n);

                queens[row][col] = '.';
            }
            
        }
    }
    public int totalNQueens(int n) {
        char[][] queens = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                queens[i][j] = '.';
            }
        }   
        
        solve(queens,0,n);
        return count;
    }
}