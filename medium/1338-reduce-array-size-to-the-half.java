class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int num: arr)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        int res=0;
        int removed=0;
        
        while(true)
        {   
            Map.Entry<Integer,Integer> temp = pq.poll();
            removed += temp.getValue();
            res++;

            if(removed>=arr.length/2) break;

        }
        return res;
        
    }
}