import java.math.BigInteger;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Factorial {

  private static enum ERROR { NEGATIVE, INFINITY };

  private static void error_message(ERROR e) {
    if (e == ERROR.NEGATIVE) {
      System.out.println("Error - requested factorial of negative number.");
      System.exit(0);
    }
    else if (e == ERROR.INFINITY)
      System.out.println("Error - requested factorial exceeds range of double");
  }

  private static long fact_least_sig_digits(long z) {
    long i; 
    long result=1;
    if (z<0) 
      error_message(ERROR.NEGATIVE);
    for (i=z; i>0; i--) 
      result=(result*i)%1000000000;
    return result;
  }

  private static BigInteger fact_big_int(BigInteger z) {
    BigInteger i;
    BigInteger result=BigInteger.ONE;
    if (z.compareTo(BigInteger.ZERO)==-1) 
      error_message(ERROR.NEGATIVE);
    for (i=z; i.compareTo(BigInteger.ZERO)!=0; i=i.subtract(BigInteger.ONE)) 
      result=result.multiply(i);
    return result;
  }

  private static long most_sig_digits(double d) {
    if (d < 1000000000)
      return Math.round(d);
    else if (d < Double.MAX_VALUE)
      return Long.parseLong(Double.toString(d).split("E")[0].replaceAll("\\.",""));    
    else 
      error_message(ERROR.INFINITY);
    return 0;
  }

  private static long fact_double(long z) {
    long i;
    double result=1;
    if (z<0) 
      error_message(ERROR.NEGATIVE);
    for (i=z; i>0; i--) 
      result=result*i;
    return most_sig_digits(result);
  }

  public static long fact_sterling(long n) {
    double result;
    result = Math.sqrt(2.0*Math.PI*n)*Math.pow(n,n)*Math.pow(Math.E, -n);
    return most_sig_digits(result);
  }

  public static void main(String[] args) {
    long f=200; // the upper bound on the double data type
    System.out.println(f);
    System.out.println("Using a bigint: " + fact_big_int(BigInteger.valueOf(f)));
    System.out.println("The first 9 digits with double are " + (fact_double(f) < 1 ? "Error" : fact_double(f)) );
    System.out.println("The last 9 digits with mod 10^9 are " + fact_least_sig_digits(f));
    System.out.println("The first 9 digits of the sterling approximation is " + (fact_sterling(f) < 1 ? "Error" : fact_sterling(f)));
  }
}
