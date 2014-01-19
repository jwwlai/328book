import java.util.*;
import java.io.*;
public class Quicksort {
    public static void main(String[] args) {
    	String filename = "in.txt";
    	File toBeSorted = new File(filename);
		try{
			Scanner in = new Scanner(toBeSorted);
			// System.out.println("Input Size of the array");
			int n = in.nextInt();
			Integer[] ar = new Integer[n];
			int min = 0;
			int max = n;
			for(int i=0;i<n;i++)
			  ar[i]=min + (int)(Math.random() * ((max - min) + 1));


			//calculate time for quicksort algorithm to run
			long startTime = System.currentTimeMillis();
			quickSort(ar, 0, ar.length-1);
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Size: " + n + " Total time quicksort: "+ totalTime);
		}
		catch(Exception e){
			System.out.println(e);
		}
   }
    
    public static void quickSort(Integer[] ar, int left, int right) {
    	//this check insures we don't go out of bounds
    	if(left < right){
    		//partition the current sub array
    		int q = partition(ar, left, right);
    		//quicksort the left half of our sub array
    		quickSort(ar, left, q-1);
    		//quicksort the right half of our sub array
    		quickSort(ar, q+1, right);
    	}
    }  
	public static int partition(Integer[] ar, int p, int r) {
		//initiliaze the pivot
		//lets make optimize the pivot a little bit
		int med = medianOfThree(ar, p, r);//find the median of the first, last and middle number
		swap(ar, med, r);//swap the median with the last number in the array
		Integer pivot = ar[r];//set the pivot to be the last number just like before
		//initialize the sub array of numbers less than the pivot to end at -1
		int i = p -1;
		//initialize the sub array of numbers greater than the pivot to end at 0, 
		//this will also act as our iterator throught the current array
		for(int j = p; j< r; ++j) {
			//if the current number is less than pivot, place that number at the end
			//of the "subarray" that contains the numbers less than the pivot
			if(ar[j].compareTo(pivot) <= 0){
				//incrementing "i" here gives you a place to put your element
				//at the end of your sub array on the left
				++i;
				swap(ar, i, j);
			}
		}
		//this places the pivot at the end of sub array with all the numbers smaller than the 
		//pivot
		swap(ar, i+1, r);
		return i+1;
	}
	public static void swap(Integer[] array, int leftPos, int rightPos){
		Integer tmp = array[leftPos];
		array[leftPos] = array[rightPos];
		array[rightPos] = tmp;
	}
	public static int medianOfThree(Integer[] ar, int l, int r){
		int middle = (l + r)/2;
		//if the element on the left is the least, compare the other two, and return the smaller
		if(ar[l].compareTo(ar[middle]) < 0 && ar[l].compareTo(ar[r]) < 0){
			if(ar[middle].compareTo(ar[r]) < 0){
				return middle;
			}
			return r;
		}
		else if(ar[middle].compareTo(ar[l]) < 0 && ar[middle].compareTo(ar[r]) < 0){
			if(ar[l].compareTo(r)< 0){
				return l;
			}
			return r;
		}
		//here the right must be the least
		else{
			if(ar[l].compareTo(ar[middle])< 0){
				return l;
			}
			return middle;
		}
	}
}