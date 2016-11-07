package ross;
import java.io.*;
import java.util.HashMap;
import java.util.*;
import static java.lang.System.out;

public class Anagram {

  private static int cVal(String s, int i) {
    return Character.getNumericValue(s.charAt(i))-10;
  }

  public static int numberNeeded(String first, String second) {

    int[] freq1=new int[26];
    int[] freq2=new int[26];
    int count=0, i=0;
    for(i=0; i<first.length();i++) 
      freq1[cVal(first,i)]++;
    for(i=0; i<second.length();i++) 
      freq2[cVal(second,i)]++;
    for(i=0; i<26; i++) {
      count+= Math.abs(freq1[i]-freq2[i]);
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }
}
