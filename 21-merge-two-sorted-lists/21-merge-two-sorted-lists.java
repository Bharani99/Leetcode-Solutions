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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), ans = head;
        ListNode left = list1, right = list2;
        while(left !=  null && right != null){
            if(left.val <= right.val){
                head.next = left;
                head = head.next;
                left = left.next;
            }
            else{
                head.next = right;
                head = head.next;
                right = right.next;
            }
        }
        while(left != null){
            head.next = left;
            head = head.next;
            left = left.next;
        }
        while(right != null){
            head.next = right;
            head = head.next;
            right = right.next;
        }
        return ans.next;
    }
}