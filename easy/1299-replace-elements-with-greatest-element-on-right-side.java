class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        if(n==1) return new int[]{-1};

        
        for(int i=0;i<n;i++)
        {   int max=-0;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]>max)
                {
                    max=arr[j];                  
                }
            }
            arr[i]=max;
        }
        arr[n-1]=-1;
        return arr;
    }
}