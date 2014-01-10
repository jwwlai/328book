public class LinkedListTester{
	public static void main(String[] args) {
		Linkedlist a = new Linkedlist(6);
		System.out.println(a.toString());
		for(int i = 0; i<10; ++i){
			a.insertNode(i, i);
		}
		System.out.println(a);
	}
}