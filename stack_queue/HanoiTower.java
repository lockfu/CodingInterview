package stackandqueue;

import java.util.Iterator;
import java.util.Stack;

public class HanoiTower {
	
	public static void print(Stack<Integer> s){
		Iterator<Integer> itor = s.iterator();
		while(itor.hasNext()){
			System.out.printf("%d " , itor.next());
		}
		System.out.println();
	}
	
	public static void resolve(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
		if(n == 0) return;
		resolve(n-1, a, c, b);
		c.push(a.pop());
		resolve(n-1, b, a, c);
	}
	
	public static void main(String[] args) {
		int count = 32;
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> c = new Stack<>();
		
		for(int i = count; i> 0; i--){
			a.push(i);
		}
		print(a);
		long start = System.currentTimeMillis();
		resolve(count, a, b, c);
		long end = System.currentTimeMillis();
		print(c);
		System.out.println("time: " + (end - start) / 1000);
	}
}
