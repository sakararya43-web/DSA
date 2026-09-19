class Solution {
    private static boolean isvalid(StringBuilder res)
    {
        int count =0;
        for( int i=0;i<res.length();i++)
        {
            if(res.charAt(i)=='(') count++;
            else{
                count--;
            }
            if(count<0) return false;
        }
        if(count==0) return true;
        return false;
    }
    
    private static void solve(int n,StringBuilder sb,List<String> res,int open,int close)
    {
        if(sb.length()== 2*n)
        {
            if(isvalid(sb))
            {
                res.add(sb.toString());
            }
            return;
        }
        if(open < n)
        {    sb.append('(');
            solve(n,sb,res,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open)
        {   sb.append(')');
            solve(n,sb,res,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        int open =0,close=0;
        solve(n,sb,res,open,close);

        return res;
    }
}