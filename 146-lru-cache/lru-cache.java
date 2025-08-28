class LRUCache {
    class Node{
        int key;
        int value;
        Node prev, next;

        Node(int key, int value){
            this.key=key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer,Node> cache;
    private final Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void insert(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev =head;
        node.next = temp;
        temp.prev = node;
    }
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);

        if (cache.size()>capacity){
            Node lru =tail.prev;
            remove (lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */