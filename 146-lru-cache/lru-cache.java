class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    ListNode(int key, int value){
        this.key = key;
        this.value = value;
        prev =null;
        next = null;
    }
}
class LRUCache {
    int capacity;
    ListNode head =new ListNode(-1,-1);
    ListNode tail =new ListNode(-1,-1);
    Map<Integer, ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            removeNode(node);
            addNodeAtTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addNodeAtTail(node);
        }else{
            if(capacity==map.size()){
                ListNode node =head.next;
                removeNode(node);
                map.remove(node.key);
            }
            ListNode newNode = new ListNode(key,value);
            addNodeAtTail(newNode);
            map.put(key,newNode);
        }
        
    }
    public void addNodeAtTail(ListNode node){
        node.next =tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */