package stackandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	private final static int STACK_SIZE = 5; 
	ArrayList<Stack<Integer>> stacks = new ArrayList<>();
	public void push(int value){
		Stack<Integer> last = getLast();
		if(null == last || last.size() >= 5){
			Stack<Integer> newStack = new Stack<>();
			last.add(value);
			stacks.add(newStack);
		}else{
			last.add(value);
		}
	}
	public int pop(){
		Stack<Integer> last = getLast();
		if(null == last)
			throw new RuntimeException("empty stack");
		int value = last.pop();
		if(last.size() <= 0)
			stacks.remove(stacks.size()-1);
		return value;
	}
	
	private Stack<Integer> getLast(){
		if(stacks.size() > 0)
			return stacks.get(stacks.size()-1);
		return null;
	}
}
