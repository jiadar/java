
/**
  Author:
  Date: 10/19/2016
  Assignment: Exercise 8
 */

/*
 Determine and write the output of each problem; if there are errors, 
 explain what they are; if you can fix it to produce a result, do so
 Write your answers on a piece of paper, or type them at the bottom of
 each problem.  If you're stumped, copy and paste it into the main
 function to see what you get.
 */

public class Detective {
  public static void main(String[] args) {
    //one();     // Run an infinite loop
    //two();     // Fix semicolon, counts down from 10 to 0
    //three();   // Infinite loop, change || to &&
    //four();    // Print the sum of the even elements, except the last one
    //five();    // Print i am \n tire
    //six();     // Prints 5 test values: 76.0, 46.3, 26.6, 13.4, and 4.6 then exits
    //seven();   // Sums into elt n, n<4 elt n+i if elt n < elt i. Result 98 93 86 64 43 9 71 3 99 50 
    //eight();   // Prints names and balances, 
  }


  public static void one() {
    int i = 0;
    while(i < 10) {
      System.out.println(i);
      i++; // added incrementor so loop will terminate
    }
  }

  public static void two() {
    for(int i = 10; i >= 0; i--)
      System.out.println(i);          //needed semicolon 
  }

  public static void three() {
    int count = 1;
    boolean a = true, b = true;
    while(a && b) {
      if(a) {
        a = false;
        b = true;
      }
      else if(b) {
        a = true;
        b = false;
      }
      System.out.println(count);
      count++;
    }
  }
  public static void four() {

    int sum, i;
    int [] values = {5, 8, 3, 1, 7, 6, 2, 8, 2, 9, 4};
    for(i = sum = 0; i < 10; i = i + 2)
      sum += values[i];
    System.out.println("Sum = " + sum);
  }

  public static void five() {
    char [] ch = {'i', 't', 'r', 'm', ' ', '\n', 'a', 'i', 'e', 'd'}; // change " to '
    int ix = 7;
    while(ix != 9)
    {
      System.out.print(ch[ix]);
      if(ix == 5)
        ix -= 4;
      else if(ix == 1)
        ix--;
      else if(ix == 2)
        ix += 6;
      else if(ix == 8)
        ix++;
      else if(ix == 9)
        System.exit(0);
      else if(ix > 4)
        ix -= 3;
      else
        ix += 2;
    }
  }

  public static void six() {

    double testValue = 76;
    while(testValue >= 0 && testValue <= 100)
    {
      System.out.println("Test value = " + testValue);
      testValue = (testValue * 2 - 13) / 3;
    }
  }
  public static void seven() {
    //7
    int [] ary = {5, 7, 22, 64, 43, 9, 71, 3, 99, 50};
    int n = 10;
    for(int i = 0; i < n; i++)
    {
      for(int j = i+1; j < (n / 2); j++)
      {
        //System.out.println("i = " + i + "j = " + j);
        if(ary[i] < ary[j]) {
          //System.out.println("adding into elt " + i + " : " + ary[i] + " + " + ary[j]);
          ary[i] += ary[j];
          //for(int q = 0; q < n; q++)
          //  System.out.print(ary[q] + " ");          
        }
      }
    }
    for(int i = 0; i < n; i++)
      System.out.print(ary[i] + " ");
  }
  public static void eight() {
    int option=1; // needed equals 
    String [] directory = {"Sarah", "John", "Amanda", "Bob", "Mike", "Mary"};
    double [] balance = {183.44, 219.47, 27.38, 375.48, 472.74, 388.55};
    int dirSize = 6;

    while(option != 0)
    { 
      if(option == 1)
      {
        for(int i = 0; i < dirSize; i++)     // needs to be < to stay in bounds
          System.out.println(directory[i]);

        option = 3;
      }
      else if(option==2) // needs to be ==
      {
        for(int i = 0; i < dirSize; i++) // i needs to be instantiated , < to stay in bounds
          System.out.println(directory[i] + "\'s balance is " + balance[i]); // needed +
        option = 0; //add to terminate loop
      }
      else if(option == 0)
      {
        System.out.println("Exiting...");
      }
      else
      {
        System.out.println("Invalid entry, try again");
        option = 2;
      }
    }
  }
}
