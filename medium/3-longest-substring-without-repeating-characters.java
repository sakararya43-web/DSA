class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int l=0,r=0,maxlen=0;

        while(r<s.length())
        {
            if(mp.containsKey(s.charAt(r)))
            {
                if(mp.get(s.charAt(r))>=l)
                {
                    l = mp.get(s.charAt(r))+1;
                }
            }
            else{
                mp.put(s.charAt(r),1);
            }
            int len = r-l+1;
            maxlen = Math.max(len,maxlen);

            mp.put(s.charAt(r),r);
            r++;
        } 
        return maxlen;
    
    }
}