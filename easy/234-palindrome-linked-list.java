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
    public boolean isPalindrome(ListNode head) {
        int [] arr= new int[length(head)];
        ListNode temp =head;
        int i=0;
        while(temp!=null)
        {
            arr[i]=temp.val;
            i++;
            temp=temp.next;
        }

        int left=0,right=arr.length-1;
        while(left<=right)
        {
            if(arr[left]!=arr[right]) return false;

            left++;
            right--;
        }
        return true;
    }
}