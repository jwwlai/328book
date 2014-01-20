public class Linkedlist{
	/*
		inner class, to represent our nodes
	*/
	public class Node{
		public int data;
		public Node next;
		public String toString(){
			Integer d = (Integer) data;
			return d.toString();
		}
	}
	//the data member
	private Node head;
	//default 
	public Linkedlist(){
		head = null;
	}
	public Linkedlist(int val){
		this.head= new Node();
		this.head.data = val;
		this.head.next = null;
	}
	//shallow copy
	public Linkedlist(Linkedlist a){
		this.head = a.head;
	}
	public Linkedlist clone(){
		Linkedlist a = new Linkedlist();
		return a;
	}
	public String toString(){
		Node n = this.head;
		String out = "";
		while(n != null){
			out = out+ " "+n.toString();
			n = n.next;
		}
		out += " null";
		return out;
	}

	public int compareTo(){
		return 0;
	}
	public int size(){
		Node n = this.head;
		int i = 0;
		while(n != null){
			i++;
			n = n.next;
		}
		return i;
	}
	public void insertAtFront(int val){
		Node insert = new Node();
		insert.data = val;
		insert.next = this.head;
		this.head = insert;
	}
	public void insertNode(int position, int val){
		if(position> this.size() || position < 0){
			System.out.println("Error: You can't place a node there");
			return;
		}
		Node n = this.head;
		if(position==0){
			insertAtFront(val);
			return;
		}
		while(position> 1){
			n = n.next;
			position--;
		}
		Node toInsert = new Node();
		toInsert.data = val;
		toInsert.next = n.next;
		n.next = toInsert;
	}
}