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
    private static List<Integer> solve(TreeNode root)
    {
        Queue<TreeNode> q =new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        q.offer(root);
        while(!q.isEmpty())
        {   int n = q.size();
            list.add(q.peek().val);
            while(n>0)
            {
                TreeNode temp = q.poll();
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                n--;
            }
                       
        }
        return list;
    }
    public List<Integer> rightSideView(TreeNode root) {
        return solve(root);
    }
}