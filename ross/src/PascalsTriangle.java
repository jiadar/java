import java.util.Scanner;
import java.math.BigInteger;
import java.lang.StringBuilder;

/*
Input Format 
The first line contains the number of test cases T. 
T lines follow each containing an integer n.

Output Format 
For each n output the list of nC0 to nCn each separated by a single space in a new line. 
If the number is large, print only the last 9 digits. i.e. modulo 10^9

Constraints 
1<=T<=200 
1<=n< 1000
 */

public class PascalsTriangle {
  public static final int MOD=1000000000;
  private static Scanner in = new Scanner(System.in);

  private static String modString(BigInteger n) {
    String nstr=new StringBuilder(n.toString()).reverse().toString();
    String rval="          ";
    for (int i=(nstr.length()>=9 ? 8 : nstr.length()-1); i>=0; i--) {

        rval += nstr.toString().charAt(i);
    }
    return rval.trim();
  }
  
  public static void main(String[] args) {

    int i, k, t, v;
    int[] n = new int[200];

    t=in.nextInt();
    for(i=0; i<t; i++) {
      n[i] = in.nextInt();
    }

    for(i=0;i<t;i++) {
      BigInteger[] r = new BigInteger[n[i]+1];
      r[0]=BigInteger.ONE;
      System.out.print(modString(r[0]) + " ");
      for(k=1;k<=n[i];k++) {
        r[k] = r[k-1].multiply(BigInteger.valueOf(n[i]+1-k));
        r[k] = r[k].divide(BigInteger.valueOf(k));
        System.out.print(Long.parseLong(modString(r[k])) + (k==n[i] ? "" : " "));
      }
      System.out.println();
    }
  }
}

