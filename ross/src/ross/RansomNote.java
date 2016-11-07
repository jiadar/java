package ross;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.out;

public class RansomNote {

  private static void loadDictionary(Hashtable<String,Integer> dict, int m, Scanner in) {
    String k;
    for(int i=0; i < m; i++) {
      k=in.next();
      if (dict.containsKey(k)) 
        dict.replace(k, dict.get(k)+1);
      else
        dict.put(k, 1);
    }    
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    int i=0;
    boolean result=true;
    String word;
    Hashtable<String,Integer> magazine=new Hashtable<String,Integer>();
    loadDictionary(magazine, m, in);
    while(result && i<n) {
      word=in.next();
      if (magazine.containsKey(word)) {
        if (magazine.get(word)>1) 
          magazine.replace(word, magazine.get(word)-1);
        else
          magazine.remove(word);
      }
      else 
        result=false;
      i++;
    }    
    out.println(result ? "Yes" : "No");
  }
}
