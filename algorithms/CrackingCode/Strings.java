import java.util.*;
public class Strings {
	public static void main(String [] argv){
		Scanner in = new Scanner(System.in);
		String string1 = in.nextLine();
		String string2 = in.nextLine();
		System.out.println(isAnagram(string1, string2));	
	}
	/**
		Example 1.1 - Determine if a string is made up of individual characters
	*/
	//use a hash map to check the characters
	public static boolean hasUnique(String s){
		//create a map
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//for each character in the string, check to see if the map contains that character
		//if it does, we can return false
		//if it doesn't, place that character in the map and continue
		for(int i = 0; i<s.length(); ++i){
			Character cur = s.charAt(i);
			if(map.containsKey(cur)){
				return false;
			}
			map.put(cur, 1);
		}
		return true;
	}
	public static boolean hasUniqueNoDataStructure(String s){
		return true;
	}	
	/**
		Example 1.2 - Print a string in reverse order
	*/
	public static void printReverse(String s){
		final int beginningOfString = 0;
		printReverse(stringToArray(s), beginningOfString);
		//we haven't put in a new line character yet, so we do that here
		System.out.println("");
	}
	public static char[] stringToArray(String str){
		str += '\0';
		char[] ar = new char[str.length()];
		for(int i = 0; i< str.length(); i++){
			ar[i] = str.charAt(i);
		}
		return ar;
	}
	//print the rest of the string reversed, then print this character
	public static void printReverse(char[] s, int addressToPrint){
		//we know we don't want to print anymore if we find the null character
		//else, we want to the rest of the string in reverse, before we print
		if(s[addressToPrint] != '\0'){
			printReverse(s, addressToPrint + 1);
		}
		System.out.print(s[addressToPrint]);		
	} 
	public static boolean isAnagram(String s1, String s2){
		HashMap<Character, Integer> s1map = makeMap(s1);
		HashMap<Character, Integer> s2map = makeMap(s2);
		Set<Character> s1keys = s1map.keySet();
		for(Character s: s1keys){
			if(s1map.get(s) != s2map.get(s))
				return false;
		}
		return true;	
	}
	public static HashMap<Character, Integer> makeMap(String s){
		HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); ++i){
			Character cur = s.charAt(i);
			//if we don't have the character in our map, place it 
			//with a value of 1
			if(!mapping.containsKey(cur)){
				mapping.put(cur, 1);
			}
			//if we do, increment the current count
			else{
				mapping.put(cur, mapping.get(cur)+1);
			}
		}
		return mapping;
	}
}

