package linear;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {

    private Stack stack1, stack2;

    public StackQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void enqueue(int value){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        int top = (int) this.stack1.pop();
        return top;
    }

    @Override
    public String toString(){
        return Arrays.toString(stack1.toArray());
    }

}
