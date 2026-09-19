class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        StringBuilder sb = new StringBuilder("");   
        String ans ="";
        int cnt = 0;
        for(int r=0;r<s.length();r++)
        {
            char ch = s.charAt(r);
            sb.append(ch);
            if(ch=='1') cnt++;
          
                while(cnt>k)
                {
                    if(sb.charAt(l)=='1')
                    {
                        cnt--; 
                    }
                    sb.deleteCharAt(l);
                    
                }
            if(cnt==k)
            {
                while(sb.charAt(l)=='0')
                {
                    sb.deleteCharAt(l);                
                }
            
                String st = sb.toString();
                if(ans.equals("") || st.length() < ans.length() || st.length() == ans.length() && st.compareTo(ans) < 0)
                
                {
                    ans = st;
                }
            }

        }
        
        return ans;
        
    }
}