import java.util.*;
public class insertionSort <T extends Comparable<T> >{
    
  public static <T extends Comparable<T>> void insertionSort(T[] ar){
      for(int i = 1; i<ar.length; i++){
          T a = ar[i];
          int j;
          for(j = i; j >0; j--)
          {
              if(a.compareTo(ar[j-1]) < 0 ){
                  ar[j] = ar[j-1]; 
              }   
              else break;
          }
          ar[j] = a;
      }
  }
  public static <T>void printArray(T[] ar) {
      for(T n: ar){
          System.out.print(n+" ");
      } 
      System.out.println("");
  }
       
  public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           Integer[] ar = new Integer[n];
           for(int i=0;i<n;i++){
              ar[i]=(Integer)in.nextInt(); 
           }
           insertionSort(ar);
           printArray(ar);
  }    
}