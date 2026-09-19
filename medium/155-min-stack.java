class MinStack {
    
    class pair
    {
        int data;
        int min;
        pair(int data,int min)
        {
            this.data=data;
            this.min=min;
        }
    }
    Stack<pair>st;
    public MinStack() {
        st= new Stack<>();
    }
    
    public void push(int value) {
        
        if(st.isEmpty())
        {
            st.push(new pair(value,value));
        }
        else{
            int currmin= Math.min(st.peek().min,value);
            st.push(new pair(value,currmin));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().data;
    
    }
    
    public int getMin() {
        return st.peek().min;

        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */