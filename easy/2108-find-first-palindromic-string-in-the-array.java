class Solution {
    public String firstPalindrome(String[] words) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {          
            list.add(words[i]);
        }
        for(String x: list)
        {
            String reversed = new StringBuilder(x).reverse().toString();
            if(x.equals(reversed))
            {
                return x;
            }
        }
        return "";
    }
}