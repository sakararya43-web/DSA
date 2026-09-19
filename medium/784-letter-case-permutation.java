class Solution {
    private void solve(int start,String s,List<String>list,StringBuilder sb)
    {
        if(start == s.length())
        {
            list.add(sb.toString());
            return;
        }

        char ch = s.charAt(start);
        if(Character.isDigit(ch))
        {
            sb.append(ch);
            solve(start+1,s,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        else
        {
            sb.append(Character.toLowerCase(ch));
            solve(start+1,s,list,sb);
            sb.deleteCharAt(sb.length()-1);
               
            sb.append(Character.toUpperCase(ch));
            solve(start+1,s,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }              
            
        
    }
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        List<String> list = new ArrayList<>();
        
        solve(0,s,list,sb);
        return list;
    }
}