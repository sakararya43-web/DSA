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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key> root.val)
        {
            root.right = deleteNode(root.right,key);
            return root;
        }
        else if(key<root.val)
        {
            root.left = deleteNode(root.left,key);
            return root;
        }
        else
        {
                if(root.left==null && root.right==null)
                {
                    return null;
                }
                else if(root.left==null)
                {
                    TreeNode temp  = root.right;
                    return temp;
                }
                else if(root.right==null)
                {
                    TreeNode temp = root.left;
                    return temp;
                }
                else
                {
                    TreeNode child = root.left;
                    TreeNode parent = root;

                    while(child.right!=null)
                    {
                        parent = child;
                        child = child.right;
                    }
                    if(root!=parent)
                    {
                        parent.right = child.left;
                        child.left =root.left;
                        child.right = root.right;
                        return child;

                    }
                    else{
                        child.right = root.right;
                        return child;
                    }
                }

            
        }
    }
}