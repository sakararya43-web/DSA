class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        
        int total=0;
        for(int i : nums)
        {   int temp=i;
        int max_digit=0;
            while(temp>0)
            {
              max_digit=Math.max(max_digit,temp%10);
              temp/=10;            
            }
            int encrypted=0;
            temp=i;
            while(temp>0)
            {
              encrypted=encrypted*10 + max_digit;
              temp/=10;
            }
            total+=encrypted;
        }
       return total;
    }
}