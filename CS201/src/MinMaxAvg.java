
public class MinMaxAvg {
  public static void main(String[] args) {
    int numbers[][] = { 
        { 63, 82, 92, 76, 98 },
        { 98, 70, 65, 89, 91 },
        { 84, 99, 85, 59, 55 },
        { 89, 92, 94, 90, 96 },
        { 56, 35, 26, 17, 61 }
    };
    int min=0, max=0;
    double avg=0;
    for(int i=0; i<numbers.length; i++) {
      System.out.print("Row #" + i + ": "); 
      for(int j=0;j<numbers[i].length; j++) {
        System.out.print(numbers[i][j] + " ");
      }
      System.out.println("min= " + min + " max = " + max + " avg = " + avg);
    }
    for(int i=0; i<numbers.length; i++) {
      System.out.print("Col #" + i + ": "); 
      for(int j=0;j<numbers[i].length; j++) {
        System.out.print(numbers[j][i] + " ");
      }
      System.out.println("min= " + min + " max = " + max + " avg = " + avg);
    }
  }
}