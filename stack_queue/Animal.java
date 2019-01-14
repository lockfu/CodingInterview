package stackandqueue;

public abstract class Animal {
	private int order;
	private String name;
	public Animal(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlderThean(Animal a){
		return this.order < a.getOrder();
	}
}
