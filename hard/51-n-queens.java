class Solution {
    private boolean isValid(List<List<Character>> list,int row,int col,int n)
    {
        //upward
        for(int i=row-1;i>=0;i--)
        {
            if(list.get(i).get(col)=='Q') return false;
        }

        //left diagonal
        for(int i=row-1,j = col-1;i>=0 && j>=0;i--,j--)
        {
            if(list.get(i).get(j)=='Q') return false;
        }

        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
        {
            if(list.get(i).get(j)=='Q') return false;
        }
        return true;
    }
    private void solve(List<List<Character>> list,List<List<String>> ans,int row,int n)
    {
        if(row==n)
        {           
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++)
                {
                    sb.append(list.get(i).get(j));
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isValid(list,row,col,n))
            {
                list.get(row).set(col, 'Q');

                solve(list,ans,row+1,n);

                list.get(row).set(col, '.');
            }
            
        }
    }
    public List<List<String>> solveNQueens(int n) {
        
        List<List<Character>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>(Collections.nCopies(n,'.')));
        }   
        List<List<String>> ans = new ArrayList<>();
        solve(list,ans,0,n);
        return ans;

    
    }
}