import java.util.concurrent.ThreadLocalRandom;

public class InsertionSortArray {
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
  
  public static void is(String msg, int[] n, int a, int b, int c) {
    int i, j, temp;
    for(i=0; i<n.length; i++) {
      j=i;
      while (j>0 && n[j-1]>n[j]) {
        temp=n[j];
        n[j]=n[j-1];
        n[j-1]=temp;
        j--;
      }
    }
  }

  public static void main(String[] args) {
    int[] numbers = new int[100];
    for (int i=0; i<100; i++)
      numbers[i]=ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
    System.out.println("Original Array:");
    printArray("orig", numbers,0,0,0);
    is("is", numbers, 0, 0, 0);
    //Arrays.sort(numbers);
    System.out.println("\nSorted Array:");
    printArray("final", numbers,0,0,0);
 }
}

