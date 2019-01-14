package stackandqueue;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> tail;
	Stack<Integer> head;
	
	public MyQueue() {
		head = new Stack<>();
		tail = new Stack<>();
	}
	
	public void shiftStack(){
		if(head.isEmpty()){
			while(!tail.isEmpty()){
				head.push(tail.pop());
			}
		}
	}
	
	public void push(int value){
		tail.push(value);
	}
	public int peek(){
		shiftStack();
		return head.peek();
	}
	public int pop(){
		shiftStack();
		return head.pop();
	}
}
