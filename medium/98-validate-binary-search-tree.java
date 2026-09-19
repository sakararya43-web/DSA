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
    private static List<Integer> solve(TreeNode root,List<Integer> list)
    {
        if(root==null) return null;

        solve(root.left,list);
        list.add(root.val);
        solve(root.right,list);
        return list;
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(root,list);
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i-1)>=list.get(i)) return false;
        }
        return true;
    }
}