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
    {   int c=0;
        ListNode temp = head;
        while(temp!=null)
        {
            temp=temp.next;
            c++;
        }

        return c;           
    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
    
        int c=0;
        int a=0;
        int n=length(head);
        ListNode temp =head;
        ListNode q= head;
        
        while(temp!=null)
        {
            c++;
            if(c==k)
            {
                break;
            }
            temp=temp.next;
        }
        while(q!=null)
        {
            a++;
            if(a==(n-k+1))
            {
                break;
            }
            q=q.next;
        }
        int t=temp.val;
        temp.val=q.val;
        q.val=t;

        return head;
    
    
    }
}