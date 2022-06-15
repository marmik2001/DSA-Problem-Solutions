class MinStack {
    HashMap<Integer,Integer> map;
    PriorityQueue<Integer> pq;
    Stack<Integer> stack;
    
    public MinStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        pq.add(val);
        stack.push(val);
    }
    
    public void pop() {
        int remove = stack.pop();
        map.put(remove,map.getOrDefault(remove,0)+1);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        while(map.containsKey(pq.peek())){
            int peek = pq.peek();
            int count = map.get(peek);
            while(count!=0){
                pq.poll();
                count--;
            }
            map.remove(peek);
        }
        return pq.peek();
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