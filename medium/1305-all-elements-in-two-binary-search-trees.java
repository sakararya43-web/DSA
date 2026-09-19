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
    private static List<Integer> solve1(TreeNode root1,List<Integer> list)
    {   
        if(root1==null) return null;
        solve1(root1.left,list);
        list.add(root1.val);
        solve1(root1.right,list);

        return list;

    }
    private static List<Integer> solve2(TreeNode root2,List<Integer> list)
    {   
        if(root2==null) return null;
        solve2(root2.left,list);
        list.add(root2.val);
        solve2(root2.right,list);
        return list;

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        solve1(root1,list);
        solve2(root2,list);
        Collections.sort(list);
        return list;
        

    }
}