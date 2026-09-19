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
        for(int i=inEnd;i>=inStart;i--)
        {
            if(inorder[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
    private static TreeNode tree(int [] postorder,int[] inorder,int inStart,int inEnd,int index)
    {   if(inStart>inEnd) return null;
        TreeNode root = new TreeNode(postorder[index]);

        int pos = find(inorder,postorder[index],inStart,inEnd);
        root.right = tree(postorder,inorder,pos+1,inEnd,index-1);
        root.left = tree(postorder,inorder,inStart,pos-1,index-(inEnd-pos)-1);

        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return tree(postorder,inorder,0,inorder.length-1,inorder.length-1);
    }
}