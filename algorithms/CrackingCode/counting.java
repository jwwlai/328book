import java.util.*;
import java.io.*;
public class Counting{
	public static void main(String[] args) {
		String filename = "in.txt";
		File input = new File(filename);
		try{

			Scanner in = new Scanner(input);
			System.out.println("Input size of the array");
			int n = Integer.parseInt(in.nextLine());
			System.out.println("Input min value.");
			int min = Integer.parseInt(in.nextLine());
			System.out.println("Input max value.");
			int max = Integer.parseInt(in.nextLine());
			Integer [] ar = new Integer[n]; 
			for(int i = 0; i < n; ++i){
					ar[i] = min+ (int)(Math.random()*((max - min)+1));
			}
			countingSort(ar, min, max);
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void countingSort(Integer[] array, int minimumValue, int maximumValue){
		Integer[] sorted = new Integer[maximumValue - minimumValue];
		for(int i = 0; i< array.length; ++i){
			++sorted[array[i]-minimumValue];
		}
		System.out.println(Arrays.toString(sorted));
	}
}