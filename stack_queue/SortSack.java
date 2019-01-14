package stackandqueue;

import java.util.Iterator;
import java.util.Stack;

public class SortSack {
	public static Stack<Integer> sortedStack(Stack<Integer> st){
		Stack<Integer> sorted = new Stack<>();
		while(!st.isEmpty()){
			int tmp = st.pop();
			while(!sorted.isEmpty() && sorted.peek() > tmp){
				st.push(sorted.pop());
			}
			sorted.push(tmp);
		}
		return sorted;
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(2);
		st.push(3);
		st.push(1);
		st.push(9);
		
		st = sortedStack(st);
//		Iterator<Integer> itor = st.iterator();
		while(!st.isEmpty()){
			System.out.print(st.pop() + " ");
		}
		
	}
}
