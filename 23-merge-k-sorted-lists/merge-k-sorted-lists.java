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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode node:lists){
            if(node!=null){
                minheap.offer(node);
            }
        }
        ListNode dummy =new ListNode(0);
        ListNode curr = dummy;

        while(!minheap.isEmpty()){
            ListNode node = minheap.poll();
            curr.next = node;
            curr =curr.next;
            if(node.next!=null){
                minheap.offer(node.next);
            }
        }
        return dummy.next;
    }
}