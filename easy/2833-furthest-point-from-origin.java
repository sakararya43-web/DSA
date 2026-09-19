class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        char[] arr=moves.toCharArray();
        int c1=0;
        int c2=0;
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            if(moves.charAt(i)=='L')
            {
                c1++;
            }
            else if(moves.charAt(i)=='R')
            {
                c2++;
            }
            else{
                c++;
            }
        }
        return Math.abs(c2-c1)+c;
    }
}