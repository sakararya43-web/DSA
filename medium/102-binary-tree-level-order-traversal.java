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
    private static List<List<Integer>> solve(List<List<Integer>> ans,Queue<TreeNode> q,TreeNode root)
    {
        if(root==null) return ans;
        q.offer(root);
        TreeNode temp  = new TreeNode();
        while(!q.isEmpty())
        {   int size = q.size();
            List<Integer> res = new ArrayList<>();
            while(size>0)
            {
                temp = q.poll();
                res.add(temp.val);
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                size--;
            }
            ans.add(res);
            
        }
        return ans;

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        return solve(ans,q,root);
    }
}