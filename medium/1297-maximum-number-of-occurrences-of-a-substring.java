class Solution {
    private static int countunique(String str)
    {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            set.add(str.charAt(i));
        }
        return set.size();
    }
    private static int solve(String s,int maxLetters,int minSize, int maxSize)
    {   HashMap<String,Integer> map = new HashMap<>();
        int c=0;
        int min =minSize;
        for(int r=0;r+min<=s.length();r++)
        {
            String str = s.substring(r,min+r);
            int count= countunique(str);
            if(count<=maxLetters)
            {
                map.put(str,map.getOrDefault(str, 0) + 1);
                c = Math.max(c, map.get(str));
            }
            
        }
        
        return c;


    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        return solve(s,maxLetters,minSize,maxSize);
    }
}