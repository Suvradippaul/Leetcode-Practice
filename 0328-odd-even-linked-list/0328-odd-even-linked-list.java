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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head;       // the first node
        ListNode temp = head.next;     // the second node
        ListNode evenHead = temp;
        while (oddHead != null && oddHead.next != null && temp != null && temp.next != null) {
            oddHead.next = oddHead.next.next;
            oddHead = oddHead.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        oddHead.next = evenHead;
        return head;
    }
}