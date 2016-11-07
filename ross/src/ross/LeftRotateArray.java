package ross;

import java.io.*;
import java.util.*;

public class LeftRotateArray {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int d = in.nextInt();
    int a[] = new int[n];
    for(int i=0; i < n; i++){
      a[i] = in.nextInt();
    }
    for(int i=d; i<n; i++) {
      System.out.print(a[i] + " ");
    }
    for(int i=0; i<d; i++) {
      System.out.print(a[i] + " ");
    }
  }
}