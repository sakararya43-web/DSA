/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       ListNode temp = head;
       temp =temp.next;
       ListNode prev = head;
       ArrayList<Integer> list = new ArrayList<>();
       int c=1;
       while(temp!=null && temp.next!=null)
       {    c++;
            if(prev.val<temp.val && temp.val>temp.next.val || prev.val>temp.val && temp.val<temp.next.val)
            {
                list.add(c);
            }
            
            temp=temp.next;
            prev=prev.next;
       }
       int [] arr= new int[2];
       if (list.size() < 2) {
             return new int[]{-1, -1};
        }
       int min = Collections.min(list);
       int max = Collections.max(list);
       arr[1]=max-min;
       int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            minDist = Math.min(minDist, list.get(i) - list.get(i - 1));
        }

        arr[0] = minDist;
       return arr;
       

       
    }
}