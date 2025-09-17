class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    ListNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    int capacity;
    int size;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            //remove the node and add it at the front
            removeNode(node);
            addNodeAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //get the Node from hashmap and update value
            ListNode node = map.get(key);
            node.value = value;
            //disconnect from the DLL (remove node)
            removeNode(node);
            //connect at head pointer (add node at head)
            addNodeAtHead(node);

        }else{
            if(capacity==size){
                //remove LRU which is at tail
                ListNode node = tail.prev;
                removeNode(node);
                //remove form hashmap
                map.remove(node.key);
                //decrement size;
                size--;
            }
                //create a new node with key and value
                ListNode newNode = new ListNode(key,value);
                //add at head
                addNodeAtHead(newNode);
                //add elem to hashmap (key and node)
                map.put(key,newNode);
                //increment size;
                size++;
        }
    }
    public void addNodeAtHead(ListNode node){
        //add at head position
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    public void removeNode(ListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */