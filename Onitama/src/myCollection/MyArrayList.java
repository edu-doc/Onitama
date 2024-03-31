package myCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        array = (E[]) new Object[initialCapacity];
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);  // Grow of 50%

            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            array = MyArrayList.copyOf(array, newCapacity);
        }
    }

    @Override
    public boolean add(E arg0) {
        ensureCapacity(size + 1);
        array[size++] = arg0;
        return true;
    }

    @Override
    public void add(int index, E arg1) {
        // Add the element at the specified index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = arg1;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        Iterator<? extends E> it = arg0.iterator();

        while (it.hasNext()) {
            add(it.next());
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> arg1) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Iterator<? extends E> it = arg1.iterator();

        while (it.hasNext()) {
            add(index++, it.next());
        }

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }

    @Override
    public boolean contains(Object arg0) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(arg0)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        Iterator<?> it = arg0.iterator();

        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object arg0){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(arg0)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return array[index++];
            }
        };
    }

    @Override
    public int lastIndexOf(Object arg0) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(arg0)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public boolean remove(Object arg0) {
        @SuppressWarnings("unchecked")
        E element = (E) arg0;

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return element;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        Iterator<?> it = arg0.iterator();

        while (it.hasNext()) {
            remove(it.next());
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        Iterator<?> it = iterator();

        while (it.hasNext()) {
            if (!arg0.contains(it.next())) {
                it.remove();
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object set(int index, Object arg1) {
        E element = array[index];

        array[index] = (E) arg1;
        return element;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public List subList(int arg0, int arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    @Override
    public Object[] toArray() {
        return MyArrayList.copyOf(array, size);
    }

    @Override
    public Object[] toArray(Object[] arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
    private static <E> E[] copyOf(E[] original, int newLength) {
        @SuppressWarnings("unchecked")
        E[] copy = (E[]) new Object[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }
}
