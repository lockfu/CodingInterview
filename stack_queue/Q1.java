package stackandqueue;

public class Q1 {
	class StackFix{
		private int stackSize = 100;
		private int[] stackPointer = {-1,-1,-1};
		private int[] buffer = new int[3*stackSize];
		
		public void push(int stackNum, int value) throws Exception{
			if(stackPointer[stackNum] + 1 >= stackNum)
				throw new Exception("Out of Space");
			stackPointer[stackNum]++;
			buffer[absTopOfStack(stackNum)] = value;
		}
		public int pop(int stackNum) throws Exception{
			if(stackPointer[stackNum] == -1)
				throw new Exception("Empty space");
			int value = buffer[absTopOfStack(stackNum)];
			buffer[absTopOfStack(stackNum)] = 0;
			stackPointer[stackNum]--;
			return value;
		}
		public int peek(int stackNum) throws Exception{
			if(stackPointer[stackNum] == -1)
				throw new Exception("Empty space");
			return buffer[absTopOfStack(stackNum)];
		}
		public boolean isEmpty(int stackNum){
			return stackPointer[stackNum] == -1;
		}
		private int absTopOfStack(int stackNum){
			return stackNum*stackSize + stackPointer[stackNum];
		}
	}
	
	
	class StackData{
		public int start;
		public int pointer;
		public int size = 0;
		public int capacity;
		public StackData(int _start, int _capacity){
			start = _start;
			pointer = start - 1;
			capacity = _capacity;
		}
		
		public boolean isWithinStack(int index, int total_size){
			if(start <= index && index < start + capacity)
				return true;
			else if(start + capacity > total_size && index < (start + capacity) % total_size)
				return true;
			return false;
		}
		
	}
	
	class StackFlex{
		int num_of_stacks = 3;
		int default_size = 4;
		int total_size = default_size * num_of_stacks;
		StackData[] stacks = {
				new StackData(0, default_size),
				new StackData(default_size, default_size),
				new StackData(default_size * 2, default_size)				
		};
		int[] buffer = new int[total_size];
		
		public int numberOfElements(){
			return stacks[0].size + stacks[1].size + stacks[2].size;
		}
		
		public int nextElement(int index){
			if(index + 1 == total_size) return 0;
			return index + 1;
		}
		
		public int previousElement(int index){
			if(index == 0) return total_size - 1;
			return index -1;
		}
		
		public void shift(int stackNum){
			StackData stack = stacks[stackNum];
			if(stack.size >= stack.capacity){
				int nextStack = (stackNum + 1) % num_of_stacks;
				shift(nextStack);
				stack.capacity++;
			}
			
			// move ele on reverse direction
			for(int i = (stack.start + stack.capacity - 1) % total_size; stack.isWithinStack(i, total_size); i = previousElement(i)){
				buffer[i] = buffer[previousElement(i)];
			}
			
			buffer[stack.start] = 0;
			stack.start = nextElement(stack.start);
			stack.pointer = nextElement(stack.pointer);
			stack.capacity--;
		}
		
		public void expand(int stackNum){
			shift((stackNum + 1) % num_of_stacks);
			stacks[stackNum].capacity++;
		}
		
		public void push(int stackNum, int value) throws Exception{
			StackData stack = stacks[stackNum];
			if(stack.size >= stack.capacity){
				if(numberOfElements() >= total_size)
					throw new Exception("All Space Full!!");
				expand(stackNum);
			}
			stack.size++;
			stack.pointer = nextElement(stack.pointer);
			buffer[stack.pointer] = value;
		}
		
		public int pop(int stackNum) throws Exception{
			StackData stack = stacks[stackNum];
			if(stack.size == 0)
				throw new Exception("Empty Stack");
			int value = buffer[stack.pointer];
			buffer[stack.pointer] = 0;
			stack.pointer = previousElement(stack.pointer);
			stack.size--;
			return value;
		}
		
		public int peek(int stackNum){
			return buffer[stacks[stackNum].pointer];
		}
		
		public boolean isEmpty(int stackNum){
			return stacks[stackNum].size == 0;
		}
	}
	
	
	
	
	
}
