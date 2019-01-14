package stackandqueue;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin>{
		public void push(int value){
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}
		public NodeWithMin pop(){
			NodeWithMin n = (NodeWithMin)super.pop();
			return n;
		}
		public int ppop(){
			return pop().value;
		}
		public int min(){
			if(this.isEmpty())
				return Integer.MAX_VALUE;
			return peek().min;
		}
}


class NodeWithMin{
	public int value;
	public int min;
	public NodeWithMin(int v, int min){
		value = v;
		this.min = min;
	}
}
