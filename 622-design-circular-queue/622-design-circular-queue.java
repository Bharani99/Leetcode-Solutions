class MyCircularQueue {
    int[] arr;
    int head, tail, size, fill;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        head = 0;
        tail = 0;
        size = k;
        fill = 0;
    }
    
    public boolean enQueue(int value) {
        if(arr[tail] != -1) return false;
        arr[tail ++] = value;
        fill++;
        if(tail == size) tail = 0;
        return true;
    }
    
    public boolean deQueue() {
        if(arr[head] == -1) return false;
        arr[head ++] = -1;
        fill--;
        if(head == size) head = 0;
        return true;
    }
    
    public int Front() {
        return arr[head];
    }
    
    public int Rear() {
        return (tail == 0) ? arr[size - 1] : arr[tail - 1];
    }
    
    public boolean isEmpty() {
        return fill == 0;
    }
    
    public boolean isFull() {
        return fill == size;
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