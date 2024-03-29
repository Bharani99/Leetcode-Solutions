class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
        stack.push(min);
    }
    
    public void push(int val) {
        if(val <= min){
            min = val;
            stack.push(val);
            stack.push(val);
        }
        else{
            stack.pop();
            stack.push(val);
            stack.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        if(stack.peek() == min) {
            stack.pop();
            min = stack.peek();
        }
        else{
            stack.pop();
            stack.push(min);
        }
    }
    
    public int top() {
        stack.pop();
        int ans = stack.peek();
        stack.push(min);
        return ans;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */