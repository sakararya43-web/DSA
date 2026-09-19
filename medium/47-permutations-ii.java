class Solution {
    private static void solve(int[] nums ,List<Integer> list,List<List<Integer>> ans,HashMap<Integer,Integer> map)
    {     
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int key:map.keySet())
        {
            if(map.get(key)>0)
            {                  
                list.add(key);
                map.put(key,map.get(key)-1);
                
                solve(nums,list,ans,map);
                
                list.remove(list.size()-1);
                map.put(key,map.get(key)+1);

                
                
            }


        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        solve(nums,list,ans,map);
        return ans;

    }
}