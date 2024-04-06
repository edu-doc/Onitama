package myCollection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collection;

public interface MyList<E> extends Iterable<E>{
    boolean add(E arg0);

    void add(int index, E arg1);

    boolean addAll(Collection<E> arg0);

    boolean addAll(int index, Collection<E> arg0);

    void clear();

    boolean contains(E arg0);

    boolean containsAll(Collection<E> arg0);

    E get(int index);

    int indexOf(E arg0);

    boolean isEmpty();

    Iterator iterator();

    int lastIndexOf(E arg0);

    ListIterator listIterator();

    ListIterator listIterator(int index);

    boolean remove(E arg0);

    E remove(int index);

    boolean removeAll(Collection<E> arg0);

    boolean retainAll(Collection<E> arg0);

    E set(int index, E arg1);

    int size();
}