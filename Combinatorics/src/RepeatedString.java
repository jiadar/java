import java.util.Scanner;
import static java.lang.System.out;

public class RepeatedString {
  
  private static long CountAs(String s, int len) {
    long count=0;
    for (int i=0; i<len; i++)   
      count+= s.charAt(i) == 'a' ? 1 : 0; 
    return count;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s=in.next();  
    long n=in.nextLong();
    long len=s.length();
    System.out.println((CountAs(s,s.length())*((long) Math.floor(n/len)))+CountAs(s, (int) (n%len)));
  }
}
