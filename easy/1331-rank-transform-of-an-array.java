class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int [] nums = new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i]));
            }
            else{
                map.put(nums[i],j);
                j++;
            }
        }
        int i=0;
        for(int num:arr)
        {
            arr[i] = map.get(num);
            i++;
        }
        return arr;


    }
}