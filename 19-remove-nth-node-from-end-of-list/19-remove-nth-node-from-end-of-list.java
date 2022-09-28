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
    public void removeNode(ListNode head, int[] n){
        if(head == null) return;
        removeNode(head.next, n);
        if(n[0] == 0){
            head.next = head.next.next;
        }
        n[0]--;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] tracker = new int[]{n};
        removeNode(head, tracker);
        return (tracker[0] == 0) ? head.next : head;
    }
}