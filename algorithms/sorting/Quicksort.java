import java.util.*;
import java.io.*;
public class Quicksort {
    public static void main(String[] args) {
    	String filename = "in.txt";
    	File toBeSorted = new File(filename);
		try{
			Scanner in = new Scanner(toBeSorted);
			int n = in.nextInt();
			Integer[] ar = new Integer[n];
			for(int i=0;i<n;i++)
			  ar[i]=(Integer)in.nextInt(); 
			quickSort(ar, 0, ar.length-1);
		    System.out.println(Arrays.toString(ar));
		}
		catch(Exception e){
			System.out.println(e);
		}
   }
    
    public static void quickSort(Integer[] ar, int left, int right) {
    	Arrays.toString(ar);
    	if(left < right){
    		int q = partition(ar, left, right);
    		quickSort(ar, left, q-1);
    		quickSort(ar, q+1, right);
    	}
    }  
	public static int partition(Integer[] ar, int p, int r) {
		//initiliaze the pivot
		Integer pivot = ar[r];
		int i = p -1;
		for (int j = p; j< r; ++j) {
			//if the current number is less than pivot
			if(ar[j].compareTo(pivot) <= 0){
				++i;
				swap(ar, i, j);
			}
		}
		swap(ar, i+1, r);
		return i+1;
	}
	public static void swap(Integer[] array, int leftPos, int rightPos){
		Integer tmp = array[leftPos];
		array[leftPos] = array[rightPos];
		array[rightPos] = tmp;
	}
}