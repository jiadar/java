/**
    Author:
    Date: 10/26/2016
    Assignment: Exercise 9.1
*/

/*
   Write a function that takes as an argument the value x,
   and returns the result of the expression: 20x^4 - 12x^3 - 3x^2 + 15x + 3
   
   Note: No importing; use the power function given to you, and use it
         as a reference for writing functions (note also that main itself
     if a function!).
*/

public class Function1
{
    public static void main(String[] args)
    {
        int num = 5, pow = 2;
        System.out.println(num + "^" + pow + " == " + power(num,pow));
        System.out.println(evaluate(3.76));
    }
  
    // power function: Calculate x^n, return result
    public static double power(double x, int n)
    {
        double product = 1;
    
        // If to the power of 0, just simply return 1
        if(n == 0)
            return product;
    
        // Otherwise calculate the product and return the result
        for(int i = 0; i < n; i++)
            product *= x;
    
        return product;
    }
    
    private static double evaluate(double x) {
      // 20x^4 - 12x^3 - 3x^2 + 15x + 3
      return (20*power(x,4) - 12*power(x,3) - 3*power(x,2) + 3); 
    }
}

