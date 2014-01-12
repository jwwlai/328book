import java.util.*;
public class Permutations{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println("Input: " + input);
		int count = printPermutations(input);
		System.out.println("Number of Permutations: " + count);
	}
	public static int printPermutations(String s){
		return printPermutations("", s, 0);
	}	
	private static int printPermutations(String prefix, String s, int counter){
		if(s.length() <= 1){
			System.out.println(prefix + s);
			return counter + 1;
		}
		for(int i = 0; i< s.length(); ++i){
			counter = printPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1), counter);
		}
		return counter;
	}
}
