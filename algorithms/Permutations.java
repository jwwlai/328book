public class Permutations{
	public static void main(String[] args) {
		int count = printPermutations("", "abcd", 0);
		System.out.println("\n\n\n\n" + count);
	}
	public static int printPermutations(String prefix, String s, int counter){
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