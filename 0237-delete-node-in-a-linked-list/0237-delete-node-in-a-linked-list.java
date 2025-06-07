/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode t) {
        if(t==null)
        return;
        t.val = t.next.val;
        t.next = t.next.next;
        return;
    }
}