import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DivisibleSumPairs {

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int a[] = new int[n];
      for(int a_i=0; a_i < n; a_i++){
          a[a_i] = in.nextInt();
      }
      int count=0;
      for (int i=0; i<n; i++) 
        for (int j=0; j<n; j++) 
          if (i<j && (a[i]+a[j])%k==0) {
            //System.out.println("i,j=" + i + "," + j + " Matched: " + a[i] + "," + a[j]);
            count++;
          }
        
      System.out.println(count);
  }
}
