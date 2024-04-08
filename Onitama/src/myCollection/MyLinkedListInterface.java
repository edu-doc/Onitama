package myCollection;

public interface MyLinkedListInterface<E> extends MyList<E> {
    void addFirst(Object arg0);

    void addLast(Object arg0);

    Object getFirst();

    Object getLast();

    Object removeFirst();

    Object removeLast();
}
