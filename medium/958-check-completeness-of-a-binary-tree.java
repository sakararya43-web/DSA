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
    int ind=0;
    private int ttlnodes(TreeNode root)
    {   
        if(root==null) return 0;
        ttlnodes(root.left);
        c++;
        ttlnodes(root.right);

        return c;
    }
    private boolean check(TreeNode root,int ind)
    {
        if(root==null) return true;

        if(ind >=c) return false;
        
        return check(root.left,2*ind+1) && check(root.right,2*ind+2);
     
    }
    public boolean isCompleteTree(TreeNode root) {
        int ttlnode = ttlnodes(root);
        int ind=0;
        return check(root,ind);

    }
}