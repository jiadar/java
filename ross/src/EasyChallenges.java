import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.out;

public class EasyChallenges {

  private static int CountAs(String s, int len) {
    int count=0;
    for (int i=0; i<len; i++)   
      count+= s.charAt(i) == 'a' ? 1 : 0; 
    return count;
  }
  private static int CountAs(String s) {
    return CountAs(s, s.length());
  }
  
  private static void RepeatedString() {
    /*
     * case 1: string contains no letter a's : return 0 (works)
     * case 2: string contains a single or only a's: return n (
     * case 3: string is <= n: return count
     * case 4: string is > n: return count*n/len + count % n 
     */

    int n,i;
    String s="";
    int count=0;
    Scanner in = new Scanner(System.in);
    s=in.next();  
    n=in.nextInt();
    int numOfAs=CountAs(s); 
    int len=s.length();
    System.out.println(CountAsRecursive(s, numOfAs, len, n));
  }
  
  private static int CountAsRecursive(String s, int numOfAs, int len, int n) {
    int thisCount=0;
    if (len==0 || n==0 || numOfAs==0) thisCount=0;
    else if (numOfAs==len) thisCount=n;
    else if (n<=len) thisCount=CountAs(s, n);
    else if (n>len) thisCount=numOfAs+CountAsRecursive(s, numOfAs, len, n-len);
    //System.out.println("This count: " + thisCount);
    return thisCount;
  }
  
  private static void NonDivisibleSubset() {
    /*
(a+b)%K=0(means evenly divisible) then (a%k+b%K=K)
Hence, we take first take the remainders of all the input integers by dividing them with K, In this case we divide all the integers by K=13 which 
gives us the following set of remainders:
6 9 8 2 0 2 7 11 1 4
now look carefully in the remainder set,
i.) 11+2=13=K thus, we cannot have both 11 and 2 , we must select one of them based on the higher frequency, in this case 2 has a higher frequency 
than 11 so SELECT all the 2s
ii.) 7+6=13=K thus, we cannot have both 7 and 6 , we must select one of them based on the higher frequency, in this case 6 and 7 both have equal 
frequencies so select any one of them, let's say(we select 6)
iii.) 9+4=13=k thus, we cannot have both 9 and 4 , we must select one of them based on the higher frequency, in this case 9 and 4 both have equal 
frequencies so select any one of them, let's say(we select 9)
now we are left with remainders 1,8,0
so the final subset of remainders comes out to be

[6,9,2,2,1,8,0]
the length of this subset is the answer which is"7"

     */
    int n, k, i;
    int total=0;
    Scanner in = new Scanner(System.in);
    n=in.nextInt();
    k=in.nextInt();  
    if (k<2) {
      System.out.println(1);
      System.exit(0);
    }
    int[] freq = new int[k];
    for (i=0; i<n; i++) {
      freq[in.nextInt()%k]++;
    }
    if (freq[0]>0) total++;
    //System.out.println(Arrays.toString(freq));
    for(i=1; i<=(Math.floor(k/2)); i++) {
      if (i != (k-i)) {
        total += Math.max(freq[i], freq[k-i]);
        //System.out.println("i=" + i + " k-i=" + (k-i) + " total=" + total);
      }
    }
    if (k%2 == 0) total++;
    System.out.println(total); // should be 45876
  }
  
  private static void RotateArrayFast() {
    int n, k, q;
    Scanner in = new Scanner(System.in);
    n=in.nextInt();
    k=in.nextInt();  
    q=in.nextInt();
    k=k%n;
    int[] numbers = new int[n];
    int[] queries = new int[q];
    for (int i=0; i<n; i++) {
      numbers[i]=in.nextInt();
    }
    for (int i=0; i<q; i++) {
      queries[i]=in.nextInt();
    }
    for(int i=0; i<q; i++)     
      System.out.print(numbers[queries[i]-k >= 0 ? queries[i]-k: queries[i]-k+n]+ "\n");
  }

  private static void RotateArray() {
    int n=3, k=2, q=3;
    Scanner in = new Scanner(System.in);
    n=in.nextInt();
    k=in.nextInt();  
    q=in.nextInt();
    int[] numbers = new int[n];
    int[] queries = new int[q];
    for (int i=0; i<n; i++) {
      numbers[i]=in.nextInt();
    }
    for (int i=0; i<q; i++) {
      queries[i]=in.nextInt();
    }
    for(int i=0; i<k; i++) {
      int[] rotation = new int[n];
      for(int j=1; j<n; j++) {     
        rotation[j] = numbers[j-1];
      }
      rotation[0]=numbers[n-1];
      numbers=rotation;
    }
    for(int i=0; i<q; i++) 
      System.out.print(numbers[queries[i]]+ "\n");
  }

  private static void Staircase() {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();  
    for (int i=0; i<len; i++) {
      String row = "";
      for (int j=0; j<len; j++) {
        if(i>=(len-1-j)) row+="#";
        else row+=" ";
      }
      System.out.println(row);
    }
  }

  private static void TimeConversion() {
    Scanner in = new Scanner(System.in);
    String dateStr = in.next();
    DateFormat readFormat = new SimpleDateFormat( "hh:mm:ssaa");
    DateFormat writeFormat = new SimpleDateFormat( "HH:mm:ss");
    Date date = null;
    try {
      date = readFormat.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    System.out.println(writeFormat.format(date));
  }

  private static void Comments() {
    // divisor set
    /*
    // Get the frequency of the remainders
    Arrays.sort(rem);
    j=0;
    for(i=0; i<k; i++) {
      freq[i]=0;
      while(j<n && rem[j]==i) {
        freq[i]++;   
        j++;
      }
    }
    // Make a matrix of rem[i]+rem[j] 
    for(i=0; i<k; i++) {
      for(j=0; j<k; j++) 
        sums[i][j] = (i+j)==k ? true : false; 
    }
    System.out.println(Arrays.toString(rem));
    System.out.println(Arrays.toString(freq));
//    for(i=0; i<k; i++) 
  //    System.out.println("[" + i + "] " + Arrays.toString(sums[i]));

    // use a%k + b%k = k
    if (freq[0]>0) total++;
    
    for(i=0; i<k; i++) {
      for (j=0; j<k; j++) {
        //System.out.print("i=" + i + " j=" + j + " i+j=" + (i+j) + " freq[i]=" + freq[i] + " freq[j]=" + freq[j] + " k=" + k);
        //System.out.println(" " + ((i+j)!=(k-1)) + " " + (freq[i]>0) + " " + (freq[j]>0));
        if (i!=j) {
          if (freq[i] > freq[j]) {
            total+=freq[i];
            System.out.println(i + " " + j + " Adding frequency: " + freq[i] + " vs " + freq[j] + " total = " + total);
          }
          else {
            total+=freq[j];
            System.out.println(i + " " + j + " Adding frequency: " + freq[j] + " vs " + freq[j] + " total = " + total);
          }
        }
        else if (freq[i] > 0)
          total++;
      }
    }
    //if (freq[0]>0) total++;
     */

  }

  public static void main(String[] args) {
    RepeatedString();
  }
}
