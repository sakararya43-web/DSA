class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int r=cardPoints.length-1;
        int suml=0;
        int sumr=0;
        int sum=0;
        int maxsum=0;
        int lastsum=Arrays.stream(cardPoints).sum();
        if(cardPoints.length==k) return lastsum;
        
        for(int i=0;i<=k-1;i++)
        {
            suml=suml+cardPoints[i];
        }
        maxsum = suml;

        for(int i=k-1;i>=0;i--)
        {
            suml=suml-cardPoints[i];
            sumr=sumr+cardPoints[r];
            r--;
            maxsum=Math.max(maxsum,sumr+suml);
        }
        return maxsum;

    }
}