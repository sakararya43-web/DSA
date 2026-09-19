class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Character> st = new Stack<>();
       for(int i=0;i<num.length();i++)
       {
            while( !st.isEmpty() && k>0 && num.charAt(i)<st.peek())
            {
               st.pop();
               k--;
               
            }
            st.push(num.charAt(i));
       }
       while(k>0)
       {
            st.pop();
            k--;
       }
        
            
       
       char []arr = new char[st.size()];
       for(int i=arr.length-1;i>=0;i--)
       {
            arr[i] = st.pop();;
            
       }
        String str= new String(arr);
         int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
        i++;
        }

        str = (i == str.length()) ? "0" : str.substring(i);
       if(str.length()==k) return"0";
       return str;
       
    }
}