class Solution {
    private String solve(int idx,String[] nums,StringBuilder sb,String s)
    {
        if(idx == nums.length)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(!nums[i].equals(sb.toString()))
                {
                    s = sb.toString();
                    return s;      
                }
            }
            return "";
        }
        String ch = nums[idx];
        
        if(ch.charAt(idx)=='1')
        {
            sb.append('0');
        }
        else{
            sb.append('1');
        }
        s = solve(idx+1,nums,sb,s);
        sb.deleteCharAt(sb.length()-1);
    
        return s;
        
    }
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder("");
        String s = new String("");
        return solve(0,nums,sb,s);
    }
}