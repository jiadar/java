import java.util.Scanner;

/*
 * Given an array of integers, calculate which fraction of its elements are positive, which 
 * fraction of its elements are negative, and which fraction of its elements are zeroes, respectively. 
 * Print the decimal value of each fraction on a new line.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, 
though answers with absolute error of up to 10^-4  are acceptable.

Input Format

The first line contains an integer, , denoting the size of the array. 
The second line contains  space-separated integers describing an array of numbers .

Output Format

You must print the following  lines:

A decimal representing of the fraction of positive numbers in the array.
A decimal representing of the fraction of negative numbers in the array.
A decimal representing of the fraction of zeroes in the array.
 */

public class PlusMinus {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();  
    int p=0, n=0, z=0, d=0; 
    for (int i=0; i<len; i++) {
      d=in.nextInt();
      if (d>0) p++; 
      if (d<0) n++;
      if (d==0) z++;
    }
    System.out.print(String.format("%7.6f\n%7.6f\n%7.6f\n", (double) p/len, (double) n/len, (double) z/len));
  }
}
