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
    
    public ListNode sortList(ListNode head) {
        ListNode temp =head;
        int [] arr= new int[length(head)];
        int i=0;
        while(temp!=null)
        {
            arr[i]=temp.val;
            temp=temp.next;
            i++;
        }
        Arrays.sort(arr);
        if(head==null) return head;
        ListNode newhead = new ListNode(arr[0],null);
        ListNode mover=newhead;
        for(int j=1;j<arr.length;j++)
        {
            ListNode temp1=new ListNode(arr[j]);
            
            mover.next=temp1;
            mover=temp1;
        }
        return newhead;

    }
}