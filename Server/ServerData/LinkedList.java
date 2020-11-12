package Server.ServerData;

//Implementation of the Linked List structure
public class LinkedList {
	private Node head;
	private int size;
	
	//constructor for Linked List that creates a new head node and set size to 0 
	public LinkedList(int count) {
		setHead(new Node());
		setSize(count);
	}
	
	//print all words in the linked list 
	public void printLinkedList() {
		Node p = getHead();
		while(p != null) {
			System.out.print(p.getCard().getColor());
			if(p.getNext()!= null)
				System.out.print(" ");
			p=p.getNext();
		}
		System.out.println();
	}
	
	// adds an element to the end of the list and sets next to null
	// if the list is empty, the element is the head
	public void insert(Card a) {
		if(getHead().getCard() == null && getSize() == 0) {
			getHead().setCard(a);
			getHead().setNext(null);
		}
		
		else {
			Node card = new Node(a);
			Node pointer = getHead();
			while(pointer.getNext() != null) {
				pointer = pointer.getNext();
			}
			
			pointer.setNext(card);
		}
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	//A node of the linked list that has a member word and pointer to next node
	class Node{
		private Card card;
		private Node next;
		
		// creates a new node, setting both to null
		public Node() {
			setNext(null);
			setCard(null);
		}
		
		public Node(Card a) {
			setNext(null);
			setCard(a);
		}
		
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Card getCard() {
			return card;
		}

		public void setCard(Card card) {
			this.card = card;
		}
	}
	
		
}

