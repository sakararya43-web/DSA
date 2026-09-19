class Solution {
    private void solve(int start,int k,List<Integer> temp,List<List<Integer>> ans,int n)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(start>n) return;
        temp.add(start);
        solve(start+1,k-1,temp,ans,n);
        temp.remove(temp.size()-1);
        solve(start+1,k,temp,ans,n);

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(1,k,temp,ans,n);
        return ans;
    }
}