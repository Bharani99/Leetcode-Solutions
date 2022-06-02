class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.add(num);
        if(max.size() > min.size())
            min.add(max.poll());
        max.add(min.poll());
        min.add(max.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (double)(max.peek() + min.peek()) / 2;
        }
        else return min.peek(); 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */