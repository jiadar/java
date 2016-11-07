package ross;

import java.io.*;
import java.util.*;

public class LonelyInteger {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    int result=0;
    for(int i=0; i<n; i++) 
      result^=in.nextInt();
    System.out.println(result);
  }
  
  public static void inefficient(String[] args) {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    int i;
    int[] pairs=new int[100];
    for (i=0; i<100; i++) 
      pairs[i]=0;
    for (i=0; i<n; i++) 
      pairs[in.nextInt()]++;
    for (i=0; i<100; i++) 
      if (pairs[i]%2==1)
        System.out.println(i);
  }
}
