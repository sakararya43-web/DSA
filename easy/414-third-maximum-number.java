class Solution {
    public int thirdMax(int[] nums) {
        
        HashSet<Integer> set= new HashSet<>();
        for( int num: nums)
        {
            set.add(num);
        }
        int [] arr= new int[set.size()];
        int i=0;
        for(int num_:set)
        {
            arr[i++]=num_;
        }
        Arrays.sort(arr);
    if(arr.length==1) return arr[0];
    if(arr.length>1 && arr.length<3) return arr[1];
    
    return arr[arr.length-3];
    
    
    }
}   