class MedianFinder {
    
    PriorityQueue<Integer> left = new PriorityQueue((a,b) -> ((int)b - (int)a));
    PriorityQueue<Integer> right = new PriorityQueue();
    boolean even = true;
    

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            right.add(num);
            left.add(right.poll());
        }
        else
        {
            left.add(num);
            right.add(left.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (double) (left.peek() + right.peek())/2;
        }
        else
            return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */