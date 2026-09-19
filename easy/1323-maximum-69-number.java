class Solution {
    public int maximum69Number (int num) {
        String s=String.valueOf(num);
        char[] arr=s.toCharArray();
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]=='6')
            {
                arr[j]='9';
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}