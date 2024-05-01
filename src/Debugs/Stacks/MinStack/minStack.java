package Debugs.Stacks.MinStack;

import java.util.Stack;

public class minStack {

    Stack<Long> st = new Stack<>();;
    long mini = Integer.MAX_VALUE;



    public minStack(){
        while(st.empty() == false){
            st.pop();
        }
    }

    public void push(int value){
        long val = value;
        if(st.empty()){
            mini = val;
            st.push(val);
        }
        else{
            if(val < mini){
                st.push(2*val - mini);
                mini = val;
            }
            else{
                st.push(val);
            }
        }
        System.out.println(st);
    }

    public void pop(){
        if(st.empty()){
            return;
        }

        long el = st.pop();

        if(el < mini){
            mini = 2*mini - el;
        }
        System.out.println(st);
    }

    public int top(){
        long val = st.peek();
        if(val < mini){
            return (int) mini;
        }
        return (int) val;
    }

    public int getMin() {
        return (int) mini;
    }

    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(10);
        minStack.push(8);
        minStack.push(15);
        minStack.push(12);
        minStack.pop();
        int x = minStack.getMin(); // return -3
        minStack.pop();
        int y = minStack.top();    // return 0
        int z = minStack.getMin(); // return -2

        System.out.println(x+" , "+y+" , "+z);
    }
}
