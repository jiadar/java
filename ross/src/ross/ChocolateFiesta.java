package ross;

import java.io.*;
import java.util.*;

public class ChocolateFiesta {

  public static final int MOD=1000000007;

  public static long mod_pow2(int n) {
    long result=1;
    for (int i=0; i<n; i++)
      result=(result*2)%MOD;
    return result;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i=0, x=0; 
    long t1=0, t2=0, result=0;
    int evens=0, odds=0;
    int n=in.nextInt();
    int[] a=new int[n];
    for(i=0; i<n; i++) {
      x=in.nextInt();
      if (x%2 == 0) evens++; 
      else odds++;
    } 
    t1=mod_pow2(evens);
    t2=mod_pow2(odds-1);

    result = ((t1*t2)%MOD-1)%MOD;

    System.out.println(result);
  }  
}



