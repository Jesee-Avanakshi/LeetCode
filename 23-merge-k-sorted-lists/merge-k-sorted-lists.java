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
        if(lists==null || lists.length==0) return null;
        
        // Create a priorityQueue minheap
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b)->a.val-b.val);

        //inserting all the heads of each list to this queue
        for(ListNode node:lists){
            if(node!=null)
                minheap.offer(node);
        }
        // while my queue is not empty, i am taking out minimum value node from minheap and adding it to result
        
        ListNode dummy = new ListNode(0);
        ListNode curr =dummy;

        while(!minheap.isEmpty()){
            ListNode node = minheap.poll();
            curr.next = node;
            curr = curr.next;
             // adding the next node of the head to heap again
            if(node.next!=null){
                minheap.offer(node.next);
            }
        }

    return dummy.next;
       
    }
}