class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        String st= "";
        for(char str:s.toCharArray())
        {
            if(map.containsKey(str))
            {
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        while(!pq.isEmpty())
        {
            Map.Entry<Character, Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++)
            {
                st=st + entry.getKey();
            }
        }
        return st;

        
    }
}