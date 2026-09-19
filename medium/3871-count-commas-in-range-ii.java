class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long com= 0;
        long st= 1000;
        while(n>=st)
        {
            com += n-st+1;
            st = st * 1000;
        }
        return com;
    }
}