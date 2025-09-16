class MyCircularDeque {
    private int[] queue;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = 0;
        this.tail = k-1;
        this.queue =new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        
        head = (head-1 +capacity) % capacity;
        queue[head] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        tail = (tail+1) % capacity;
        queue[tail] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head =(head+1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return queue[head];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[tail];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */