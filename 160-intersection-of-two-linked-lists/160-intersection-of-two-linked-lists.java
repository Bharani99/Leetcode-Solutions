/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0, b = 0;
        ListNode currA = headA, currB = headB;
        while(currA != null || currB != null){
            if(currA != null){
                a++;
                currA = currA.next;
            }
            if(currB != null){
                b++;
                currB = currB.next;
            }
        }
        currA = headA;
        currB = headB;
        
        while(a > b) {
            currA = currA.next;
            a--;
        }
        while(b > a) {
            currB = currB.next;
            b--;
        }
        
        while(currA != null){
            if(currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
}