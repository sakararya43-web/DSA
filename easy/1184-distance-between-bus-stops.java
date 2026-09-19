class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n=distance.length;
        int sum1=0;
        int sum2=0;
        if(start>destination)
        {
            int temp=start;
            start =destination;
            destination=temp;
        }
        for(int i=start;i<destination;i++)
        {
                sum1+=distance[i];
        }
        for(int j=n-1;j>=0;j--)
        {
                sum2+=distance[j];   
        }
        sum2=Math.abs(sum2-sum1);
        return Math.min(sum1,sum2);
    }
}