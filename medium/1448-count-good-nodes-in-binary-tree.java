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
    int c=0;
    class Pair{
        TreeNode node;
        int max;
        Pair(TreeNode node,int max)
        {
            this.node = node;
            this.max = max;
        }
    }
    private int trav(TreeNode root)
    {   
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,root.val));
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            TreeNode node = temp.node;
            int max = temp.max;
            
            if(node.val >= max) c++;

            int n_max = Math.max(node.val,max);

            if(node.left!=null) q.add(new Pair(node.left,n_max));

            if(node.right!=null) q.add(new Pair(node.right,n_max));     

        }
        return c;
    }
    public int goodNodes(TreeNode root) {
        return trav(root);
    }
}