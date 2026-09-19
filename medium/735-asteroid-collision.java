class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            
                if(asteroids[i]>0)
                {
                    st.push(asteroids[i]);
                }
                else{
                    
                      while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                      {
                        st.pop();
                      }
                      if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i]))
                      {
                        st.pop();
                      }
                      
                      else if(st.isEmpty() || st.peek()<0)
                      {
                        st.push(asteroids[i]);
                      }
                }
            
        }
        int [] arr = new int[st.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=st.peek();
            st.pop();
        }
        int low=0;
        int high= arr.length-1;

        while(low<high)
        {
            int temp = arr[low];
            arr[low]= arr[high];
            arr[high]= temp;
            low++;
            high--;
        }
        return arr;
    }
}