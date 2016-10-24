import java.util.Scanner;

public class DiagonalSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int[][] matrix = new int[len][len];
    long p=0, s=0;
    int i, j;
    for (i=0; i<len; i++) 
      for (j=0; j<len; j++) 
        matrix[i][j]=in.nextInt();
    for (i=0; i<len; i++) {
      p+=matrix[i][i];
      s+=matrix[i][len-i-1];
    }
    System.out.print(Math.abs(p-s));
  }
}
