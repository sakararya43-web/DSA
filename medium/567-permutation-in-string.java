class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        int r=0,l=0;
        while(r<s2.length())
        {
            String a = s2.substring(l,r+1);
            if(a.length()==s1.length())
            {
                char[] ans = a.toCharArray();
                Arrays.sort(ans);
                if(Arrays.equals(ans,arr)) return true;
            
                l++;
            }
            r++;
        }
        return false;

        
    }
}