class Solution {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        int maxprod =Integer.MIN_VALUE;
        int prod=1;
        while(n>0)
        {
            int a = n % 10;
            list.add(a);
            n/=10;

        }
        Collections.sort(list);
        for(int i=1;i<list.size();i++)
        {
            prod = list.get(i-1) * list.get(i);
            maxprod = Math.max(maxprod,prod);
        }
        return maxprod;
        
    }
}