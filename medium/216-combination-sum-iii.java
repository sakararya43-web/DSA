class Solution {
    private void findcombinations(int index,int k,int n,List<List<Integer>> ans,List<Integer> ds)
    {   
        if(ds.size()==k)
        {
            if(n==0)
            {
                ans.add(new ArrayList<>(ds));
                return;
            }
        }
        if(index > 9 || n<0) return;

        
        ds.add(index);
        findcombinations(index+1,k,n-index,ans,ds);
        ds.remove(ds.size()-1);        
        findcombinations(index+1,k,n,ans,ds);



    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombinations(1,k,n,ans,new ArrayList<>());
        return ans;
    }
}