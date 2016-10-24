import java.io.*;
import java.util.*;

public class ArraySum {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long sum=0;
    int len=in.nextInt();
    for (int i=0; i<len; i++) {
      sum+=in.nextInt();
    }
    System.out.print(sum);
  }
}
