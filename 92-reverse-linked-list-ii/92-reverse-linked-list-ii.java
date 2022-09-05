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
    public ListNode reverse(ListNode head, int right, int left){
        if(head == null) return null;
        ListNode curr = head, prev = null, next;
        while(curr != null && left <= right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left++;
        }
        head.next = curr;
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) return reverse(head, right, left);
        int index = 1;
        ListNode curr = head;
        while(index + 1 < left){
            curr = curr.next;
            index++;
        }
        curr.next = reverse(curr.next, right, left);
        return head;
    }
}