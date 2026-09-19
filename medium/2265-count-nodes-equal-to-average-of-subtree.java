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
    class Pair{
        int count;
        int sum;
        Pair(int count,int sum)
        {
            this.count=count;
            this.sum=sum;
        }
    }
    int count=0;
    private Pair value(TreeNode root)
    {
        if(root==null)
        {
            return new Pair(0,0);
        }
        Pair l = value(root.left);
        Pair r = value(root.right);

        int cnt = 1 + l.count + r.count;
        int sum = root.val + l.sum + r.sum;

        if(root.val == sum/cnt)
        {
            count++;
        }
        return new Pair(cnt,sum);

    }
    public int averageOfSubtree(TreeNode root) {
        value(root);
        return count;

    }
}