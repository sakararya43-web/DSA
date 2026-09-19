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
    private int lvlsum(TreeNode root,int lvl)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int maxsum=Integer.MIN_VALUE;
        int maxlvl=1;
        int currlvl=1;
        while(!q.isEmpty())
        {   int size = q.size();
            int lvlsum=0;

            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.poll();                   
                lvlsum+=temp.val;
                if(temp.left!=null) q.offer(temp.left);

                if(temp.right!=null) q.offer(temp.right);
                    
            }
            if(lvlsum > maxsum)
            {
                maxsum = lvlsum;
                maxlvl = currlvl;
            }
            currlvl++;
                     
        }     

        return maxlvl;
    }
    public int maxLevelSum(TreeNode root) {
       
        return lvlsum(root,1);

        

    }
}