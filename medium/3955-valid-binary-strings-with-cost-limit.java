class Solution {
    
    private void solve(int idx,int n,int k,List<String> list,StringBuilder sb)
    {
        if(idx == n)
        {   int cost = 0;
            for(int i=0;i<n;i++)
            {
                if(sb.charAt(i)=='1')
                {
                    cost+=i;

                    if(i>0 && sb.charAt(i-1)=='1')
                    {
                        return;
                    }
                }          
            }
            if(cost<=k) list.add(sb.toString());         
                
            return;      
        }

        sb.append('0');
        solve(idx+1,n,k,list,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append('1');
        solve(idx+1,n,k,list,sb);
        sb.deleteCharAt(sb.length()-1);
        

    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        solve(0,n,k,list,sb);
        
        return list;
    }
}