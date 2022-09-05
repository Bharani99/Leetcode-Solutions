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
    public ListNode reverse(ListNode head, int right){
        if(head == null) return null;
        ListNode curr = head, prev = null, next;
        int left = 0;
        while(curr != null && left < right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left++;
        }
        head.next = curr;
        if(left != right) return reverse(prev, left);
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode output = reverse(head, k);
        head.next = reverseKGroup(head.next, k);
        return output;
    }
}