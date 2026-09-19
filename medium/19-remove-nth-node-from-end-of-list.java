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
    {
        int c=0;
        ListNode temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            c++;
        }
        return c;

    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int a=length(head);
        int c=0;
        ListNode temp =head;
        int revnode=a-n+1;
        if(head==null || head.next==null) return null;
        if(revnode<=1)
        {
            ListNode q=head;
            head=head.next;
            q.next=null;
            return head;
        }
        while(temp!=null)
        {
            c++;
            if(c==revnode-1)
            {
                ListNode q=temp.next;
                temp.next=q.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
}