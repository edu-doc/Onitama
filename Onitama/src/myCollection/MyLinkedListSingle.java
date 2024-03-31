package myCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedListSingle <E> implements List <E>{
    class Node {
        E data;
        Node next;
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(o)) {
                return true;
            } else {
                p = p.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node p = head;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();

                E copy = p.data;
                p = p.next;
                return copy;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node p = head;

        while(p != null) {
            arr[--size] = p.data;
            p = p.next;
        }

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(E e) {
        if (e == null) return false;

        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty() || o == null) return false;

        Node p = head;
        Node prev = null;

        while (p != null) {
            if (p.data.equals(o)) {
                if (prev == null) {
                    head = head.next;
                } else if (p == tail) {
                    prev.next = null;
                    tail = prev;
                } else {
                    prev.next = p.next;
                }
                
                size--;
                return true;
            }

            prev = p;
            p = p.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object i : c) {
            if (!contains(i)) return false; 
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E i : c) {
            if (i == null) return false;
            add(i);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E i : c) {
            if (i == null) return false;
            add(index, i);
            index++;
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object i : c) {
            if (i == null || !contains(i)) return false;
            remove(i);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object i : this) {
            if (!c.contains(i)) {
                remove(i);
            }   
        }

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(0);  
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.data;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        Node p = head;
        E copy;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        copy = p.data;
        p.data = element;

        return copy;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();

        Node p = head;
        Node newNode = new Node(element);
        
        if (index == 0) {
            newNode.next = p;
            head = newNode;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        E copy;
        
        if (index == 0) { 
            copy = head.data;
            head = head.next;
            return copy;
        }
        
        Node p = head;

        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        copy = p.data;
        p.next = p.next.next;
        
        return copy;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
}
