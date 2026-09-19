class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int lstseen[]={-1,-1,-1};
        for(int i=0;i<s.length();i++)
        {
            lstseen[s.charAt(i)-'a']=i;
            if(lstseen[0]!=-1 && lstseen[1]!=-1 && lstseen[2]!=-1)
            {
                cnt=cnt+(1+ Math.min(lstseen[0], Math.min(lstseen[1], lstseen[2])));
            }
        }
        return cnt;
    }
}