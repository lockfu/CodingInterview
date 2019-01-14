package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Test {
	static class Inner{
		static int p1 = 5;
		static final int p2 = 5;
		static final int p3 = new Integer(5);
	}
	public static void main(String[] args) {
		System.out.println(Test.Inner.p1);
		System.out.println(Test.Inner.p2);
		System.out.println(Test.Inner.p3);
		
//		int j = 0; 
//		for(int i = 0; i<100; i++){
//			j = j++;
//			
//		}
//		System.out.println(j);
		
//		int[] arr = new int[]{1,2,3,4};
//		List list = Arrays.asList(arr);
//		System.out.println(list.size() + list.toString());
//		
		
		ArrayList<String> listOne = new ArrayList<>();
		listOne.add("this is list");
		Vector<String> vec = new Vector<>();
		vec.add("this is list");
		System.out.println(listOne.equals(vec));
	}
}
