/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static List<List<Integer>> zigzag(TreeNode root,List<List<Integer>> ans)
    {   if(root==null) return ans;
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            if(!s1.isEmpty())  //l to r.
            {   List<Integer> res = new ArrayList<>();
                while(!s1.isEmpty())
                {   
                    TreeNode temp = s1.pop();
                    
                    res.add(temp.val);
                    if(temp.left!=null)
                    {
                        s2.push(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        s2.push(temp.right);
                    }
                }
                ans.add(res);
            }
            else{
                // r to l.
                List<Integer> res1 = new ArrayList<>();
                while(!s2.isEmpty())
                {
                    TreeNode temp1 = s2.pop();
                    
                    res1.add(temp1.val);
                    if(temp1.right!=null)
                    {
                        s1.push(temp1.right);
                    }                
                    if(temp1.left!=null)
                    {
                        s1.push(temp1.left);
                    }
                }
                ans.add(res1);
            }
        }
        return ans;   

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans =  new ArrayList<>();
        return zigzag(root,ans);
    }
}