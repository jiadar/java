package ross;

// Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
// where each “_” is a single digit.

public class Euler206 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    long i=101010100L;
    boolean swit=false;
    do {
      i+= swit ? 30 : 40;
      swit = swit ? false : true;
    } while (! Long.toString(i*i).matches("1.2.3.4.5.6.7.8.9.0") );
    System.out.println(i + "^2 " + i*i);
    long endTime = System.nanoTime();
    System.out.println("Took "+((endTime - startTime)/1000000) + " ms"); 
  }
}
