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
    public ListNode getLastNode(ListNode list){
        while(list.next != null) list = list.next;
        return list;
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int curr = 0;
        ListNode head = list1, nextStart;
        while(curr + 1 < a){
            list1 = list1.next;
            curr ++;
        }
        nextStart = list1.next;
        list1.next = list2;
        while(curr < b){
            nextStart = nextStart.next;
            curr ++;
        }
        getLastNode(list2).next = nextStart;
        return head;
    }
}