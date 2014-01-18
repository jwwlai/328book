import java.util.*;
public class Mergesort{
	public static void main(String [] argv){
	    Scanner in = new Scanner(System.in);
	    int n = Integer.parseInt(in.nextLine());
	    Integer [] ar = new Integer[n];
	    for(int i = 0; i< n; ++i){
	    	ar[i] = Integer.parseInt(in.nextLine());
	    }
	    long numInversions = mergeSort(ar);
	    System.out.println("num of inversions: " + numInversions);
	    printArray(ar, "g");
	}
	public static long mergeSort(Integer [] ar){
		if(ar.length >1){
			Integer mid = ar.length/2;
			Integer[] leftAr = Arrays.copyOfRange(ar, 0, mid );
			Integer[] rightAr = Arrays.copyOfRange(ar, mid, ar.length);
			long x = mergeSort(leftAr);
			long y = mergeSort(rightAr);
			long 	z = merge(ar, leftAr, rightAr);
			return x + y + z;
		}
		 return 0;
	}
	public static long merge(Integer[] ar, Integer[] left, Integer[] right){
		Integer l = 0, r =0, ptr = 0;
		long inversions = 0;
		while(l<left.length && r < right.length){
			if(left[l] < right[r])
				ar[ptr++]= left[l++];
			else{
				ar[ptr++] = right[r++];
				inversions+= (long)(left.length - l);
			}
		}
		while(l<left.length)
			ar[ptr++] = left[l++];
		while(r<right.length)
			ar[ptr++] = right[r++];
		return inversions;
	}
	public static void printArray(Integer [] ar, String x){
		System.out.println(x);
		for(int i = 0; i< ar.length; i++){
			if(i % 10 ==0 && i >0)
				System.out.println();
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}
}