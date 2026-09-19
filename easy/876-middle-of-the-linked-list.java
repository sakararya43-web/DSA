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
    private static int length(ListNode head)
    {   int count=0;
        ListNode temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }
     
    
    
    public ListNode middleNode(ListNode head) {
        int c=0;
        int mid=(length(head)/2)+1;

        ListNode p =head;
        while(p!=null)
        {         
            c++;
            if(c==mid) break;
            p=p.next;
        }
        return p;



    }
}