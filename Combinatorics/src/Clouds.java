import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

public class Clouds {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i;
    int size=in.nextInt();
    int[] clouds = new int[size];
    for(i=0; i<size; i++) {
      clouds[i]=in.nextInt();
    }
    int count=0;
    i=0;
    while(i<(size-2)) {
      //System.out.println("size=" + size + " i=" + i + " count=" + count);

      if ((clouds[i+1]==0 && clouds[i+2]==0) || clouds[i+1]==1) i+=2;
      else if (clouds[i+1]==0 && clouds[i+2]==1) i+=1;
      count++;
    }
    if (i<size-1) count++;
    System.out.println(count);
  }
}

/*
 * case 1: all 0's = floor(size/2)
 */
