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
    int ind=0;
    private TreeNode tree(int[] preorder,int lower,int upper)
    {   
        if(ind==preorder.length) return null;
        if(preorder[ind]<lower || preorder[ind]>upper) return null;
        TreeNode root = new TreeNode(preorder[ind++]);
        root.left = tree(preorder,lower,root.val);
        root.right = tree(preorder,root.val,upper);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return tree(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
}