import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
  
  public static final boolean DEBUG=false;
  
  public static void printArray(String msg, int[] n, int lo, int hi, int p) {

    if (DEBUG) System.out.print(msg + " lo=" + lo + " hi=" + hi + " p=" + p + " n: ");
    for (int i=0; i<5; i++) {
      System.out.println();
      for (int j=0; j<20; j++)
      System.out.print(n[i*20+j] + " ");
    }
    System.out.println();
  }
  
  public static int partition(int[] n, int lo, int hi) {
    // Use the Lomuto partition scheme
    int temp;
    int i=lo;
    int pivot=n[hi];
    for(int j=lo; j<=hi-1; j++) {
      if(n[j] < pivot) {
        temp=n[i];
        n[i]=n[j];
        n[j]=temp;
        i++;
        if (DEBUG) printArray("ifswap", n, lo, hi, i);
      }
      temp=n[i];
      n[i]=n[hi];
      n[hi]=temp;
      if (DEBUG) printArray("hiswap", n, lo, hi, i);
    }
    if (DEBUG) printArray("endpart", n,lo,hi,pivot);
    return i;
    
  }
  public static void qs(int[] n, int lo, int hi) {

    /*
    1. Pick an element, called a pivot, from the array.
    2. Partitioning: reorder the array so that all elements with values less than the pivot come before 
       the pivot, while all elements with values greater than the pivot come after it (equal values can go 
       either way). After this partitioning, the pivot is in its final position. This is called the partition 
       operation.
    3. Recursively apply the above steps to the sub-array of elements with smaller values and separately 
       to the sub-array of elements with greater values.
     */
    int p;
    if ( lo < hi ) {
      p=partition(n, lo, hi);
      if (DEBUG) printArray("qs", n,lo,hi,p);
      qs(n,lo,p-1);
      qs(n,p+1,hi);
    }
  }
  
  public static void main(String[] args) {
    int[] numbers = new int[100];
    for (int i=0; i<100; i++)
      numbers[i]=ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
    System.out.println("Original Array:");
    printArray("orig", numbers,0,0,0);
    qs(numbers, 0, numbers.length-1);
    //Arrays.sort(numbers);
    System.out.println("\nSorted Array:");
    printArray("final", numbers,0,0,0);

 }
}
