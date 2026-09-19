class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int i=0;
        int j=n-1;
        char temp;
        for(i=0;i<=j;i++)
        {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}