class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        String result="";
        int num=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<binary.length();i++)
        {
            if(binary.charAt(i)=='1')
            {   
                sb.append('0');
            }
            else{
                sb.append('1');
            }
        }
        result=sb.toString();
        num=Integer.parseInt(result,2);
        return num;
    }
}