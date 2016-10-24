import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
Input Format 
The first line contains the number of test cases T. 
T lines follow each containing an integer n.

Output Format 
For each n output the list of nC0 to nCn each separated by a single space in a new line. 
If the number is large, print only the last 9 digits. i.e. modulo 109

Constraints 
1<=T<=200 
1<=n< 1000
 */
public class NChooseR {

  public static final int MOD=1000000000;
  //public static final int MOD=109;
  //public static final boolean DEBUG = true; 
  public static final boolean DEBUG = false; 
  //public static final boolean DEBUG1 = true;
  public static final boolean DEBUG1 = false;
  private static Scanner in = new Scanner(System.in);

  public static long modexp(long x, long y, long N) {
    //Input: Two n-bit integers x and N, an integer exponent y 
    //Output: x^y mod N
    long z; 
    if (y==0)
      return 1;
    z=modexp(x,y/2,N);
    if (y%2==0) 
      return (z*z)%N;
    else
      return (x*((z*z)%N))%N;
  }

  private static long findMMI(long n,int M) {
    // find the modulo multiplicative inverse x such that (x*n)%M=1 when M is prime
    // Use Fermat's little therom
    // If p is a prime and a is any integer not divisible by p, then a^(p - 1) - 1 is divisible by p.

    return modexp(n,M-2,M);
  }

  public static void main(String[] args) {
    int[] n = new int[100];
    BigInteger[] fact = new BigInteger[1000];
    int i, j, t; 
    BigInteger top, btm, mmi;
    BigInteger ncr;
    //compute up to 1000 factorials

    fact[0]=BigInteger.ONE;
    for(i=1;i<1000;i++) {
      fact[i]=(fact[i-1].multiply(BigInteger.valueOf((long)i)));
    }

    // grab input
    if (! (DEBUG || DEBUG1)) {
      t=in.nextInt();
      for(i=0; i<t; i++) {
        n[i] = in.nextInt();
      }
    }

    if (DEBUG || DEBUG1) {
      t = 1;
      n[0] = 100;
      n[1] = 4;
      n[2] = 5;
    }

    // compute

    for(i=0;i<t;i++) {
      // loop through all test cases
      if (!DEBUG) System.out.print("1 ");
      for(j=1;j<=n[i];j++) {
        // compute N Choose R
        // C(n,r) = n! / ( r! (n - r)! )
        top = fact[n[i]];
        if (DEBUG || DEBUG1) System.out.print("C(" + n[i] + "," + j + "): ");
        if (DEBUG) System.out.print("n=" + top + " ");
        btm = (fact[j].multiply(fact[(n[i]-j)]));
        if (DEBUG) System.out.print("d=" + btm + " (" + fact[j] + " * "+ fact[(n[i]-j)] + ") ");
        ncr = (top.divide(btm));
        if (DEBUG) System.out.print("ncr=");
        System.out.print(ncr.mod(BigInteger.valueOf(1000000000)) + " ");
        if (DEBUG || DEBUG1) System.out.println();
      }
      System.out.println();
    }

  }


}
