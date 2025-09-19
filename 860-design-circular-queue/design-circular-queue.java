class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    int capacity;
    int count;
    ListNode head;
    ListNode tail;
    public MyCircularQueue(int k) {
        capacity =k;
        count= 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        count++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = head.next;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
         return tail.val;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */