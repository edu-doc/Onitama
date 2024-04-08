package myCollection;

public class MyQueueLinkedList <T> implements MyQueueInterface <T> {

	public class Node{
		Node next;
		T dado;
		
		public Node (T dado) {
			this.dado = dado;
			this.next = null;
		}
	}
	
	Node head,tail;
	
	public MyQueueLinkedList() {
		head = null;
		tail = null;
	}
	
	@Override
	public void add(T dado) {
		Node n = new Node(dado);
		
		if(isEmpty()) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
		
		
	}

	@Override
	public T remove() {
		Node n = head;
		
		if(isEmpty()) {
			return null;
		}
		
		T retorno = n.dado;
		
		if(head==tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		
		n.next = null;
		n = null;
		
		return retorno;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return head.dado;
	}

	@Override
	public boolean isEmpty() {
		if(head == null && tail == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        Node p = head;
        while (p != null) {
            sb.append(p.dado);
            if (p.next != null) {
                sb.append(", ");
            }
            p = p.next;
        }
        sb.append("");
        return sb.toString();
    }
	
	

}