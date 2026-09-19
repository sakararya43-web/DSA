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
    {    ListNode temp = head;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int c=0;
        int n=length(head);
        int mid = (n/2)+1;
        if(mid==1 || head==null) return null;

        else if(mid==n)
        {
            while(temp.next.next!=null)
            {
                temp=temp.next;
                
            }
            temp.next=null;
            return head;
        }
        else{
            while(temp.next!=null)
            {
                
                c++;
                if(c==mid-1)
                {
                    ListNode q=temp.next;
                    temp.next=q.next;
                    break;
                    
                }
                temp=temp.next;
            }
           
        }
        return head;

    }
}