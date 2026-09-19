class Solution {
    public boolean isBalanced(String num) {
        char[] ch=num.toCharArray();
        int sumodd=0;
        int sumeven=0;
        for(int i=0;i<num.length();i++)
        {   char c= num.charAt(i);
            if(i%2==0)
            {   
                sumeven+= c -'0';
            }
            else{
                
                sumodd+= c - '0';
            }
        }
        if(sumodd==sumeven) return true;

        else return false; 
    }
}