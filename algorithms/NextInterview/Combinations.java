import java.util.*;
public class Combinations{
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		printCombinations(l);
		printNumberOfCombinations(l);
	}
	// print all the combinations of a string of size length
	public static void printCombinations(int length){
		printCombinations("", length);
	}
	private static void printCombinations(String prefix, int length){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int alphLength = alphabet.length();
		if(length==1){	
			for(int i = 0; i<alphLength; ++i){
				System.out.println(prefix + alphabet.charAt(i));
			}
			return;
		}
		for(int i = 0; i<alphLength; ++i){
			printCombinations(prefix+alphabet.charAt(i), length-1);
		}
	}
	public static void printNumberOfCombinations(int length){
		System.out.println("Number of Combinations: " + Math.pow(26, length));
	}
}