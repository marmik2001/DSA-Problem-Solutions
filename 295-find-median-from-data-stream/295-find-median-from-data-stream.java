class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size()>right.size()){
            if(left.peek()>num){
                right.add(left.poll());
                left.add(num);
            }else
                right.add(num);
        }else{
            if(right.size()!=0&&right.peek()<num){
                left.add(right.poll());
                right.add(num);
            }else
                left.add(num);
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size())return left.peek();
        return ((double)left.peek()+right.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */