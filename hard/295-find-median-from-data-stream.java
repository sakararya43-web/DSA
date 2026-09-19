class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public void balance()
    {
        if(minHeap.size()>maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        else{
            if(minHeap.size() < maxHeap.size()-1)
            {
                minHeap.add(maxHeap.poll());
            }
        }
    }
    public void addNum(int num) {
        if(maxHeap.isEmpty())
        {
            maxHeap.add(num);
            return;
        }

        if(num > maxHeap.peek())
        {
            minHeap.add(num);
        }
        else{
            maxHeap.add(num);
        }
        balance();
    }
    
    public double findMedian() {
        if(maxHeap.size()>minHeap.size())
        {
            return maxHeap.peek();
        }
        else{
            double ans = minHeap.peek()+maxHeap.peek();
            ans/=2;
            return ans;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */