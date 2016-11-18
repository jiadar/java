package ross;
import java.util.Scanner;
import java.math.BigInteger;
import java.lang.StringBuilder;

public class FibonocciModified {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger[] seq = new BigInteger[21];
    seq[1]=BigInteger.valueOf(in.nextInt());
    seq[2]=BigInteger.valueOf(in.nextInt());
    int n=in.nextInt();
    for (int i=3; i<=n; i++) {
      seq[i]=seq[i-2].add((seq[i-1].multiply(seq[i-1])));
    }
    System.out.println(seq[n]);
  }
}
