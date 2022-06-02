class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> (Integer.compare(b,a)));
    boolean flip = true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(flip){
            max.add(num);
            min.add(max.poll());
        }
        else{
            min.add(num);
            max.add(min.poll());
        }
        flip = !flip;
    }
    
    public double findMedian() {
        if(flip){
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