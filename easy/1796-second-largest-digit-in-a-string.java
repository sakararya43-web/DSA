class Solution {
    public int secondHighest(String s) {
        int n=s.length();
        int sec_max=-1;
        int max=-1;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {   int num =ch-'0';
                if(num>max)
                {   
                    sec_max=max;
                    max=num;
                }
                else if(num>sec_max && num!=max) sec_max = num;
            }
        }
        if(sec_max==max) return -1;
        
        return sec_max;
    }
}