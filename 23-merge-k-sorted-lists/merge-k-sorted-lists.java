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
        if(lists==null||lists.length==0){
            return null;
        }

        while(lists.length>1){
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = ((i+1) <lists.length)? lists[i+1]:null;
                mergedLists.add(mergeTwoLists(l1,l2));
                
            }
            lists = mergedLists.toArray(new ListNode[0]);
            
        }
        return lists[0];

    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ptr.next =l1;
                l1 =l1.next;
                ptr = ptr.next;
            }else{
                ptr.next =l2;
                l2=l2.next;
                ptr =ptr.next;
            }
             
        }
        if(l1!=null){
            ptr.next =l1;
        }
        if(l2!=null){
            ptr.next=l2;
        }
        return dummy.next;

    }
}