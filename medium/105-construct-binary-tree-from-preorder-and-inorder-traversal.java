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
    private static int find(int [] inorder,int target,int inStart,int inEnd)
    {
        for(int i=inStart;i<=inEnd;i++)
        {
            if(inorder[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
    private static TreeNode tree(int [] preorder,int[] inorder,int inStart,int inEnd,int index)
    {
        if(inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[index]);

        int pos = find(inorder,preorder[index],inStart,inEnd);
        root.left = tree(preorder,inorder,inStart,pos-1,index+1);
        root.right = tree(preorder,inorder,pos+1,inEnd,index+(pos-inStart)+1);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder,inorder,0,inorder.length-1,0);
    }
}