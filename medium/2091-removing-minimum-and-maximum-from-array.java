class Solution {
    public int minimumDeletions(int[] nums) {
      if(nums.length==1) return 1;

      int max = Arrays.stream(nums).max().getAsInt();
      int min = Arrays.stream(nums).min().getAsInt();

      int front = 0;
      int back = 0;
      int f_index = 0;
      int b_index = 0;
      for(int i=0;i<nums.length;i++)
      {
        front++;
        if(nums[i]==max || nums[i]==min)
        {
            f_index = i;
            break;
        }
      }
      for(int i=nums.length-1;i>=0;i--)
      {
        back++;
        if(nums[i]==max || nums[i]==min)
        {
            b_index = i;
            break;
        }
      }
      
        int front_ops = b_index + 1;
        int back_ops = nums.length - f_index;

        int both_ops = front + back;

        return Math.min(front_ops,Math.min(back_ops,both_ops));
    }
}