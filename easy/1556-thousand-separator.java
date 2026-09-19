class Solution {
    public String thousandSeparator(int n) {
       StringBuilder sb = new StringBuilder();
       if(n>=1000)
       {     int cnt=0;
            sb.append(n);
            for(int i =sb.length()-1;i>=0;i--)
            {
                cnt++;
                if(cnt==3)
                {
                    sb.insert(i,'.');
                    cnt=0;
                }
            }
            if(sb.charAt(0)=='.')
            {
                sb.deleteCharAt(0);
            }
            return sb.toString();
       }
       return String.valueOf(n);
        
    }
}