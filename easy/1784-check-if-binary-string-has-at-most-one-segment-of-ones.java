class Solution {
    public boolean checkOnesSegment(String s) {
        char[] arr=s.toCharArray();
        int n=s.length();
        for(int i=n-1;i>0;i--)
        {
            if(arr[i]=='1')
            {
                if(arr[i-1]=='0'&& i>=0)
                {
                    return false;
                }
            }
        }
        return true;


    }
}