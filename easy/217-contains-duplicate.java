class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashMap<Integer,Integer> mp = new HashMap<>();

       
       for(Integer num:nums)
       {
            if(mp.containsKey(num))
            {
                mp.put(num,mp.get(num)+1);
            }
            else{
                mp.put(num,1);
            }
       } 
       for(Integer value:mp.values())
       {
            if(value>1)
            {
                return true;
            }
       }
       return false;
    }
}