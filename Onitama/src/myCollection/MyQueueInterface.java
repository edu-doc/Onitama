package myCollection;

public interface MyQueueInterface <T> {
	
	void add(T dado);
	T remove();
	T peek();
	
	boolean isEmpty();
	boolean isFull();

}