package stackandqueue;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog)
			dogs.addLast((Dog)a);
		else if(a instanceof Cat)
			cats.addLast((Cat)a);
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty())
			return dequeueCat();
		else if(cats.isEmpty())
			return dequeueDog();
		Dog dog = dequeueDog();
		Cat cat = dequeueCat();
		if(dog.isOlderThean(cat))
			return dequeueDog();
		else
			return dequeueCat();
	}
	
	public Dog dequeueDog(){
		return dogs.poll();
	}
	
	public Cat dequeueCat(){
		return cats.poll();
	}
}
