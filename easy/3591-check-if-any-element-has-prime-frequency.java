class Solution {
    private boolean isprime(int n)
    {   int c = 0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0) c++;
        }
        if(c==2) return true;

        return false;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.values())
        {
            if(isprime(num)) return true;
        }
        return false;
    }
}