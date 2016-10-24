import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

public class Socks {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i;
    int size=in.nextInt();
    int[] socks = new int[size];
    for(i=0; i<size; i++) {
      socks[i]=in.nextInt();
    }
    Arrays.sort(socks);
    //System.out.println(Arrays.toString(socks));
    int count=0;
    i=1;
    while(i<size) {
      if (socks[i]==socks[i-1]) {
        count++;
        i+=2;
      }
      else i+=1;
    }
    System.out.println(count);
  }
}