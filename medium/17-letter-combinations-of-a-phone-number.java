class Solution {
    private void solve(int idx,List<String> list,String digits, HashMap<Character,String> map,StringBuilder sb)
    {
        if(idx == digits.length())
        {
            list.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String val = map.get(ch);
        for(int i=0;i<val.length();i++)
        {
            sb.append(val.charAt(i));
            solve(idx+1,list,digits,map,sb);

            sb.deleteCharAt(sb.length()-1);
        
        }


    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder("");
        List<String> list = new ArrayList<>();
        solve(0,list,digits,map,sb);
        return list;
    }
}