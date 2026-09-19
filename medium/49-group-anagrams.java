class Solution {
    private static List<List<String>> solve(String[] strs)
    {   HashMap<String,List<String>> map = new HashMap<>();

        for(String str:strs)
        {
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String new_str = new String(ch);
            
            if(!map.containsKey(new_str))
            {
                map.put(new_str,new ArrayList<>());
            }
            map.get(new_str).add(str);

        }
        return new ArrayList<>(map.values());


    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        return solve(strs);
    }
}