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
     List<Integer> list = new ArrayList<>();
     int ind=0;
    private List<Integer> swap(List<Integer> list)
    {
        int count=0;
        int first=-1,second=-1;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i-1)>list.get(i))
            {
                if(count==0)
                {
                    first = list.get(i-1);
                }
                second = list.get(i);
                count++;

               
            }            

        }
        int inda=list.indexOf(first);
        int indb=list.indexOf(second);
        if (inda != -1 && indb != -1) {
            Collections.swap(list, inda, indb);
        }
        return list;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    private void filltree(TreeNode root,List<Integer>list)
    {
        if(root==null) return;

        filltree(root.left,list);
        root.val = list.get(ind++);
        filltree(root.right,list);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(list);
        ind=0;
        filltree(root,list);


    }
}