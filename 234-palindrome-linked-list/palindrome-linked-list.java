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
    private ListNode reverseLinkedList(ListNode head){
            ListNode prev = null;
            while(head!=null){
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast =head;
        while(fast.next!=null && fast.next.next!=null){
            slow =slow.next;
            fast =fast.next.next;
        }

        ListNode newHead = reverseLinkedList(slow.next);
        ListNode first =head;
        ListNode second =newHead;

        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first =first.next;
            second =second.next;
        }
        return true;
    }
}