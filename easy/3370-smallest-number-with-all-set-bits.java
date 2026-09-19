class Solution {
    public int smallestNumber(int n) {
        String binary = Integer.toBinaryString(n);
        
        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<binary.length();i++)
        {
           sb.append('1');
        }
       return Integer.parseInt(sb.toString(),2);
    }
}