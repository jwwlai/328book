import java.util.Scanner;
public class HashTableTester{
	public static void main(String[] argv){
		final int INSERT = 1;
		final int FIND = 2;
		final int QUIT = 3;
		HashTable t = new HashTable();
		boolean done = false;
		while(!done){
			System.out.println(t);
			mainmenu();
			Scanner in = new Scanner(System.in);
			//@TODO: try catch type check
			int userChoice = in.nextInt();
			switch(userChoice){
			case INSERT: insert(t);
				break;
			case FIND: find(t);
				break;
			case QUIT: done = true;
				break;
			default: 
				break;
			}

		}
	}
	public static void insert(HashTable t){
		System.out.println("Input number to insert");
		Scanner reader = new Scanner(System.in);
		//assume valid input for now... @TODO: try catch type check
		Integer toInsert = reader.nextInt();
		if(t.insert(toInsert))
			System.out.println(toInsert + " was inserted");
		else 
			System.out.println(toInsert + " was already in table");

	}
	public static void find(HashTable t){
		System.out.println("Input number to find");
		Scanner reader = new Scanner(System.in);
		//@TODO: try catch type check
		Integer toFind = reader.nextInt();
		System.out.println("found at: "  +t.find(toFind));
	}
	public static void mainmenu(){
		System.out.println("What would you like to do?");
		System.out.println("1. Insert");
		System.out.println("2. Find");
		System.out.println("3. Quit");
	}
}