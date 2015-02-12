package array;

import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<Integer>();
    public void push(int x) {
    	if(x<=min){          
            s.push(min);
            min=x;
        }
        s.push(x);
    }

    public void pop() {
    	if(s.peek()==min) {
            s.pop();
            min=s.peek();
            s.pop();
        }else{
            s.pop();
        }
        if(s.empty()){
            min=Integer.MAX_VALUE;
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
