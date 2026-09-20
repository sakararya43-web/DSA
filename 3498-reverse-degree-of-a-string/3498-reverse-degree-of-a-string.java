class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int rd = 0;
        for(int i=0;i<n;i++)
        {
            int ind = 26-(s.charAt(i)-'a');
            rd+= ind * (i+1);
        }
        return rd;
    }
}